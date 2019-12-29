<template>
    <section>
        <div class="columns">
            <div class="column is-4 is-offset-4 is-clearfix">
                <b-field>
                    <!-- <b-input placeholder="No label" rounded></b-input> -->
                    <input
                        type="text"
                        class="input"
                        placeholder="id/username/email"
                        v-model="searchText"
                    />
                    <button class="button" @click="search">搜索</button>
                </b-field>

                <b-field label="id">
                    <b-input placeholder="id" disabled v-model="id"></b-input>
                </b-field>

                <b-field label="username">
                    <b-input placeholder="username" disabled v-model="username"></b-input>
                </b-field>

                <b-field label="email">
                    <b-input placeholder="email" disabled v-model="email"></b-input>
                </b-field>

                <b-field label="name">
                    <b-input placeholder="name" v-model="name"></b-input>
                </b-field>

                <b-field label="roles"></b-field>

                
                <div class="is-clearfix"></div>

                <b-dropdown v-model="rolesSelect" multiple aria-role="list"  >
                    <button class="button is-primary" type="button" slot="trigger">
                        <span>Selected ({{ rolesSelect.length }})</span>
                        <b-icon icon="menu-down"></b-icon>
                    </button>

                    <b-dropdown-item v-for="role in allRoles" :key="role.id" :value="role.name" aria-role="listitem" >
                        <span>{{role.name}}</span>
                    </b-dropdown-item>
                </b-dropdown>

                <div class="is-clearfix"></div>
                <hr>

                <b-fild>
                    <button class="button" @click="update">更新</button>
                </b-fild>
            </div>
        </div>
    </section>
</template>

<script>
export default {
    data() {
        return {
            searchText: null,
            id: null,
            username: null,
            name: null,
            email: null,
            rolesSelect: [],
            allRoles: null
        };
    },
    methods: {
        search: function() {
            this.id = null;
            this.username = null;
            this.name = null;
            this.email = null;
            this.rolesSelect = [];

            this.$Axios.get(`/users/search?searchText=${this.searchText}`).then(response => {
                let data = response.data;
                this.id = data.id;
                this.username = data.username;
                this.name = data.name;
                this.email = data.email;

                data.roles.forEach(element => {
                    this.rolesSelect.push(element.name);
                });
            });
        },
        update: function() {
            this.$Axios
                .put(`/users/${this.username}`, {
                    name: this.name,
                    roles: this.rolesSelect
                })
                .then(response => {
                    let data = response.data;
                    this.id = data.id;
                    this.username = data.username;
                    this.name = data.name;
                    this.email = data.email;

                    this.$buefy.toast.open({
                        message: "update success!",
                        type: "is-success",
                        position: "is-bottom"
                    });
                });
        }
    },
    created: function() {
        this.$Axios.get("/roles").then(response => {
            this.allRoles = response.data;
        });
    }
};
</script>
