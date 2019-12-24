<template>
    <div class="section">
        <!-- <b-icon icon="user-secret"> </b-icon> -->
        <div class="columns is-variable is-8">
            <div class="column is-2">
                <b-menu>
                    <b-menu-list label="menu">
                        <b-menu-item label="用户管理">
                            <b-menu-item label="全部用户" @click="getAllUser"></b-menu-item>
                            <b-menu-item label="查找用户"></b-menu-item>
                        </b-menu-item>

                        <b-menu-item label="My Account">
                            <b-menu-item label="Account data"></b-menu-item>
                            <b-menu-item label="Addresses"></b-menu-item>
                        </b-menu-item>
                    </b-menu-list>
                </b-menu>
            </div>
            <div class="column is-9">
                <UserTable :users="users"> </UserTable>
            </div>
        </div>
    </div>
</template>

<script>
import UserTable from "../components/UserTable";

export default {
    data() {
        return {
            users:null,
        };
    },
    components: {
        UserTable
    },
    methods: {
        getAllUser: function() {
            this.$Axios.get("/users").then(response=>{
                this.users=response.data
                console.log("============")
                console.log(this.users)
                console.log("============")
            })
        }
    }
};
</script>
