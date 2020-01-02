<template>
    <div class="home section">
        <b-field>
            <b-input
                placeholder="Search..."
                type="search"
                icon="search"
                icon-clickable
                @icon-click="searchIconClick"
                @focus="searchFocus"
                @blur="searchLoseFocus"
            >
            </b-input>
        </b-field>
        <!-- <b-dropdown v-model="navigation" position="is-bottom-left" aria-role="menu">
            <a class="navbar-item" slot="trigger" role="input">
                <span>Menu</span>
                <b-icon icon="menu-down"></b-icon>
            </a>

            <b-dropdown-item value="home" aria-role="menuitem">
                Home
            </b-dropdown-item>
            <b-dropdown-item value="products" aria-role="menuitem">
                Products
            </b-dropdown-item>
            <b-dropdown-item value="blog" disabled aria-role="menuitem">
                Blog
            </b-dropdown-item>
        </b-dropdown> -->

        <ul type="1" v-if="searchUlVisiable">
            <li>Coffee</li>
            <li>Tea</li>
            <li>Milk</li>
        </ul>
        <hr>
        <section>
            <h1>定时器</h1>
            <span class="tag is-warning is-large">{{ countDown }}</span>
        </section>
        <hr>
    </div>
</template>

<script>
export default {
    name: "Test",
    components: {},
    data() {
        return {
            searchUlVisiable: false,
            countDown: 10
        };
    },
    methods: {
        searchFocus: function() {
            this.searchUlVisiable = true;
            console.log("-=-=-");
        },
        searchLoseFocus: function() {
            this.searchUlVisiable = false;
            console.log("-=-=-");
        },
        countDownTimer() {
            if (this.countDown >= 0) {
                setTimeout(() => {
                    this.countDown -= 1;
                    this.countDownTimer();
                }, 1000);
            } else {
                this.countDown = 10;
                this.countDownTimer();
            }
        }
    },
    created() {
        console.log("sdfasdf");
        this.countDownTimer();
    }
};
</script>
