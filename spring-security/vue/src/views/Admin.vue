<template>
    <div class="section">
        <!-- <b-icon icon="user-secret"> </b-icon> -->
        <div class="columns">
            <div class="column is-2">
                <b-menu :accordion="accordion">
                    <b-menu-list label="Menu" >
                        <b-menu-item
                            :active="isActiveUser"
                            :expanded="isActiveUser"
                            @click="isActiveUser = !isActiveUser"
                            label="user"
                            accordion="false"
                        >
                            <b-menu-item label="Users" @click="test"></b-menu-item>
                            <b-menu-item label="Payments" disabled @click="test"></b-menu-item>
                        </b-menu-item>

                        <b-menu-item
                            :active="isActiveRole"
                            :expanded="isActiveRole"
                            @click="isActiveRole = !isActiveRole"
                            label="role"
                            accordion="false"
                        >
                            <b-menu-item label="Users" @click="test"></b-menu-item>
                            <b-menu-item label="Payments" disabled @click="test"></b-menu-item>
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
            accordion:false,
            isActiveUser: true,
            isActiveRole: true
        };
    },
    methods: {
        test: function() {
            console.log("hello world");
        }
    }
};
</script>
