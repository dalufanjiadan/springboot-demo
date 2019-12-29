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

                <b-field>
                    <b-checkbox
                        v-model="roles"
                        v-for="role in allRoles"
                        :key="role.id"
                        :native-value="role.name"
                        class="is-pulled-left"
                    >
                        {{ role.name }}
                    </b-checkbox>
                </b-field>

                <div class="is-clearfix"></div>

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
            roles: [],
            allRoles: null
        };
    },
    methods: {
        search: function() {
            this.id = null;
            this.username = null;
            this.name = null;
            this.email = null;
            this.roles = [];

            this.$Axios.get(`/users/search?searchText=${this.searchText}`).then(response => {
                let data = response.data;
                this.id = data.id;
                this.username = data.username;
                this.name = data.name;
                this.email = data.email;

                data.roles.forEach(element => {
                    this.roles.push(element.name);
                });
            });
        },
        update: function() {
            this.$Axios
                .put(`/users/${this.username}`, {
                    name: this.name,
                    roles: this.roles
                })
                .then(response => {
                    let data = response.data;
                    this.id = data.id;
                    this.username = data.username;
                    this.name = data.name;
                    this.email = data.email;
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
