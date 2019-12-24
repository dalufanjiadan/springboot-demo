<template>
    <div class="section">
        <!-- <b-icon icon="user-secret"> </b-icon> -->
        <div class="columns">
            <aside class="menu column is-2" >
                <p class="menu-label">
                    General
                </p>
                <ul class="menu-list">
                    <li><a>Dashboard</a></li>
                    <li><a>Customers</a></li>
                </ul>
                <p class="menu-label">
                    Administration
                </p>
                <ul class="menu-list">
                    <li><a>Team Settings</a></li>
                    <li>
                        <a class="is-active" @click="menuOnClick($event)">Manage Your Team</a>
                        <ul>
                            <li><a @click="menuOnClick($event)">Members</a></li>
                            <li><a @click="menuOnClick($event)">Plugins</a></li>
                            <li><a @click="menuOnClick($event)">Add a member</a></li>
                        </ul>
                    </li>
                    <li><a>Invitations</a></li>
                    <li><a>Cloud Storage Environment Settings</a></li>
                    <li><a>Authentication</a></li>
                </ul>
                <p class="menu-label">
                    Transactions
                </p>
                <ul class="menu-list">
                    <li><a>Payments</a></li>
                    <li><a>Transfers</a></li>
                    <li><a>Balance</a></li>
                </ul>
            </aside>

            
            </div>
        </div>
</template>

<script>
export default {
    data() {
        return {
            accordion: false,
            // 记录第一层目录当前选中层
            expanded1: "role"
            // isActive: true,
        };
    },
    methods: {
        menu1OnClick: function(e) {
            console.log("hello world");
            console.log(e);
        },
        testBtnOnClick: function() {
            this.$Axios.get("/users").then(data => {
                console.log("------------");
                console.log(data);
                console.log("------------");
            });
        },
        menuOnClick: function(event){
            console.log("===========================")
            console.log(event)
            event.target.classList.add("is-active")
            console.log(event.target)
            console.log("===========================")
        }
    }
};
</script>
