<template>
    <div class="section">
        <!-- <b-icon icon="user-secret"> </b-icon> -->
        <div class="columns">
            <button class="button is-primary" @click="testBtnOnClick">
                hello
            </button>

            <div class="column is-2">
                <b-menu :accordion="accordion">
                    <b-menu-list label="Menu">
                        <b-menu-item
                            :active="isActive"
                            :expanded="expanded1 === 'user'"
                            @click="menu1OnClick($event)"
                            label="user"
                            accordion="false"
                        >
                            <b-menu-item label="Users" @click="test"></b-menu-item>
                            <b-menu-item label="Payments" disabled @click="test"></b-menu-item>
                        </b-menu-item>

                        <b-menu-item
                            :active="isActive"
                            :expanded="expanded1 === 'role'"
                            @click="isActive = !isActive"
                            label="role"
                            accordion="false"
                        >
                            <b-menu-item label="Users" @click="test"></b-menu-item>
                            <b-menu-item label="Payments" @click="test"></b-menu-item>
                        </b-menu-item>
                    </b-menu-list>
                </b-menu>
            </div>
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
        }
    }
};
</script>
