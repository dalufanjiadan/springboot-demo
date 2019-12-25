<template>
    <div class="section">
        <!-- <b-icon icon="user-secret"> </b-icon> -->
        <div class="columns is-variable is-8">
            <div class="column is-2">
                <b-menu>
                    <b-menu-list label="menu">
                        <b-menu-item label="用户管理">
                            <b-menu-item
                                label="全部用户"
                                @click="onMenu('userTable')"
                            ></b-menu-item>
                            <b-menu-item label="编辑用户" @click="onMenu('userEdit')"></b-menu-item>
                        </b-menu-item>

                        <b-menu-item label="角色管理">
                            <b-menu-item label="全部角色"></b-menu-item>
                            <b-menu-item label="编辑角色"></b-menu-item>
                        </b-menu-item>
                    </b-menu-list>
                </b-menu>
            </div>
            <div class="column is-9">
                <UserTable v-if="vif.userTable"> </UserTable>
                <UserEdit v-if="vif.userEdit"></UserEdit>
            </div>
        </div>
    </div>
</template>

<script>
import UserTable from "../components/admin/UserTable";
import UserEdit from "../components/admin/UserEdit";

export default {
    data() {
        return {
            vif: {
                userTable: false,
                userEdit: false
            }
        };
    },
    components: {
        UserTable,
        UserEdit
    },
    methods: {
        onMenu: function(key) {
            for (let a in this.vif) {
                this.vif[a] = false;
            }
            this.vif[key] = true;
        }
    }
};
</script>
