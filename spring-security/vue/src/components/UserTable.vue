<template>
    <section>
        <b-table
            :data="data"
            :loading="loading"
            paginated
            backend-pagination
            :total="total"
            :per-page="perPage"
            @page-change="onPageChange"
            aria-next-label="Next page"
            aria-previous-label="Previous page"
            aria-page-label="Page"
            aria-current-label="Current page"
            backend-sorting
            :default-sort-direction="defaultSortOrder"
            :default-sort="[sortField, sortOrder]"
            @sort="onSort"
        >
            <template slot-scope="props">
                <b-table-column field="id" label="id" sortable>
                    {{ props.row.id }}
                </b-table-column>

                <b-table-column field="name" label="name" numeric sortable>
                    <span class="tag" :class="type(props.row.name)">
                        {{ props.row.name }}
                    </span>
                </b-table-column>

                <b-table-column field="username" label="username" sortable searchable>
                    {{ props.row.username }}
                </b-table-column>

                <!-- centered -->
                <b-table-column field="joinedAt" label="joinedAt" sortable >
                    {{ props.row.joinedAt }}
                </b-table-column>

                <b-table-column label="roles" >
                    <!-- {{ props.row.overview | truncate(80) }} -->
                    <!-- {{ props.row.roles}} -->
                    <span class="tag" v-for="role in props.row.roles" :key="role.id">
                        {{ role.name }} {{ role.id }}
                    </span>
                </b-table-column>
            </template>
        </b-table>
    </section>
</template>

<script>
export default {
    data() {
        return {
            data: [],
            total: 0,
            loading: false,
            sortField: "vote_count",
            sortOrder: "desc",
            defaultSortOrder: "desc",
            page: 1,
            perPage: 20
        };
    },
    props: ["users"],
    computed: {},
    methods: {
        /*
         * Load async data
         */
        loadAsyncData() {
            const params = [
                "api_key=bb6f51bef07465653c3e553d6ab161a8",
                "language=en-US",
                "include_adult=false",
                "include_video=false",
                `sort_by=${this.sortField}.${this.sortOrder}`,
                `page=${this.page}`
            ].join("&");

            this.loading = true;
            // this.$http
            //     .get(`https://api.themoviedb.org/3/discover/movie?${params}`)
            //     .then(({ data }) => {
            //         // api.themoviedb.org manage max 1000 pages
            //         this.data = [];
            //         let currentTotal = data.total_results;
            //         if (data.total_results / this.perPage > 1000) {
            //             currentTotal = this.perPage * 1000;
            //         }
            //         this.total = currentTotal;
            //         data.results.forEach(item => {
            //             item.release_date = item.release_date.replace(/-/g, "/");
            //             this.data.push(item);
            //         });
            //         this.loading = false;
            //     })
            //     .catch(error => {
            //         this.data = [];
            //         this.total = 0;
            //         this.loading = false;
            //         throw error;
            //     });

            this.$Axios.get("/users").then(response => {
                let data = response.data;
                this.data = [];

                let currentTotal = data.length;
                if (data.length / this.perPage > 1000) {
                    currentTotal = this.perPage * 1000;
                }
                this.total = currentTotal;
                data.forEach(item => {
                    this.data.push(item);
                });
                this.loading = false;
            });
        },
        /*
         * Handle page-change event
         */
        onPageChange(page) {
            this.page = page;
            this.loadAsyncData();
        },
        /*
         * Handle sort event
         */
        onSort(field, order) {
            this.sortField = field;
            this.sortOrder = order;
            this.loadAsyncData();
        },
        /*
         * Type style in relation to the value
         */
        type(value) {
            const number = parseFloat(value);
            if (number < 6) {
                return "is-danger";
            } else if (number >= 6 && number < 8) {
                return "is-warning";
            } else if (number >= 8) {
                return "is-success";
            }
        }
    },
    filters: {
        /**
         * Filter to truncate string, accepts a length parameter
         */
        truncate(value, length) {
            return value.length > length ? value.substr(0, length) + "..." : value;
        }
    },
    mounted() {
        this.loadAsyncData();
    }
};
</script>
