<template>
    <section>
        <div class="columns">
            <div class="column is-3 is-offset-3">
                <div class="field" v-for="(role, index) in roles" :key="role.id">
                    <b-tag
                        v-if="true"
                        type="is-info"
                        size="is-large"
                        closable
                        aria-close-label="Close tag"
                        @close="close(index)"
                        class="is-pulled-left"
                    >
                        {{ index + 1 }} {{ role.name }}
                    </b-tag>
                    <div class="is-clearfix"></div>
                </div>
            </div>
            <div class="column is-3">
                <b-field>
                    <input type="text" class="input" placeholder="ROLE_NAME" v-model="roleName" />
                    <button class="button" @click="add">new</button>
                </b-field>
            </div>
        </div>
    </section>
</template>

<script>
export default {
    data() {
        return {
            isTag1Active: true,
            isTag2Active: true,
            isTag3Active: true,
            roles: null,
            roleName: null
        };
    },
    created: function() {
        this.$Axios.get("/roles").then(response => {
            this.roles = response.data;
        });
    },
    methods: {
        close: function(index) {
            console.log("-=-");
            console.log(index);
            let role = this.roles[index];
            console.log(role);
            this.$Axios
                .delete(`/roles/${role.id}`)
                .then(response => {
                    console.log(response);
                    this.roles.splice(index, index + 1);
                })
                .catch(error => {
                    console.log(error);
                    this.$buefy.toast.open({
                        message: "delete fail!",
                        type: "is-danger",
                        position: "is-bottom"
                    });
                });
        },
        add: function() {
            this.$Axios
                .post("/roles", {
                    roleName: this.roleName
                })
                .then(response => {
                    this.roles.push(response.data);
                })
                .catch(error => {
                    this.$buefy.toast.open({
                        message: this.roleName + "重复",
                        type: "is-danger",
                        position: "is-bottom"
                    });
                });
        }
    }
};
</script>

<style></style>
