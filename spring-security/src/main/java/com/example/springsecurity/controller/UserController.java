package com.example.springsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.example.springsecurity.exception.AppException;
import com.example.springsecurity.exception.ResourceNotFoundException;
import com.example.springsecurity.model.security.Role;
import com.example.springsecurity.model.security.RoleName;
import com.example.springsecurity.model.security.User;
import com.example.springsecurity.payload.*;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.security.UserPrincipal;
import com.example.springsecurity.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    // @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {

        UserSummary userSummary = new UserSummary();
        userSummary.setId(currentUser.getId());
        userSummary.setName(currentUser.getName());
        userSummary.setUsername(currentUser.getUsername());

        boolean isAdmin = currentUser.getAuthorities().stream()
                .anyMatch(o -> o.toString().equals(RoleName.ROLE_ADMIN.toString()));

        userSummary.setAdmin(isAdmin);

        return userSummary;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users/{username}")
    public UserProfile getUser(@PathVariable(value = "username") String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user);
        return userProfile;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public Map<String, Object> getAll(@RequestParam Map<String, Object> params) {

        String sortField = params.get("sortField").toString();
        String sortOrder = params.get("sortOrder").toString();
        int page = Integer.parseInt(params.get("page").toString()) - 1;
        int perPage = Integer.parseInt(params.get("perPage").toString());

        Sort sort = Sort.by(sortField);

        if ("asc".equals(sortOrder)) {
            sort = sort.ascending();
        } else {
            sort = sort.descending();
        }

        // Sort.by(Direction.DESC, "id")
        Pageable pageable = PageRequest.of(page, perPage, sort);

        Page<User> users = userRepository.findAll(pageable);
        List<UserProfile> data = new ArrayList<>();
        for (User user : users) {
            data.add(new UserProfile(user));
        }

        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("total", users.getTotalElements());

        return result;
    }

    @GetMapping("/users/search")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User searchUser(@RequestParam(value = "searchText") String searchText) {

        Optional<User> user = null;

        try {
            Long id = Long.parseLong(searchText);
            user = userRepository.findById(id);
        } catch (Exception e) {
            user = userRepository.findByUsername(searchText);
            if (!user.isPresent()) {
                user = userRepository.findByEmail(searchText);
            }
        }

        return user.orElseThrow(() -> new AppException("user not found"));
    }

    @PutMapping("/users/{username}")
    public User updateUser(@PathVariable(value = "username") String username,
            @RequestBody Map<String, Object> userParam) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException("user not found"));
        user.setName(userParam.get("name").toString());

        Set<Role> roles = new HashSet<>();
        for (String roleName : (List<String>) userParam.get("roles")) {
            Role userRole = roleRepository.findByName(RoleName.valueOf(roleName))
                    .orElseThrow(() -> new AppException("User Role not set."));
            roles.add(userRole);
        }
        user.setRoles(roles);
        userRepository.save(user);

        return user;
    }

}