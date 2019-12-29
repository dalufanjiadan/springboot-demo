<template>
    <section>
        <div class="columns">
            <div class="column is-4 is-offset-4">
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

                <!-- <b-button class="is-primary">查找</b-button> -->
                <!-- <b-input class="button"></b-input> -->
                <button class="button" @click="update">更新</button>
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
            roles: null
        };
    },
    methods: {
        search: function() {
            this.$Axios.get(`/users/search?searchText=${this.searchText}`).then(response => {
                let data = response.data;
                this.id = data.id;
                this.username = data.username;
                this.name = data.name;
                this.email = data.email;
                this.roles = data.roles;
            });
        },
        update: function() {
            console.log("hello world");

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
                    this.roles = data.roles;
                });
        }
    }
};
</script>
