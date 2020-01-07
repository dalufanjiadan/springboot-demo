<template>
    <div>
        <div id="c1"></div>
    </div>
</template>

<script>
export default {
    components: {},
    created() {},
    mounted() {
        this.initComponent();
    },
    data() {
        return {
            msg: "",
            chart: null,
            data: [
                { x: 1, y: 55, type: "vh" },
                { x: 2, y: 60, type: "vh" },
                { x: 3, y: 57, type: "vh" },
                { x: 4, y: 52, type: "vh" },
                { x: 5, y: 58, type: "vh" },
                { x: 1, y: 45, type: "hv" },
                { x: 2, y: 40, type: "hv" },
                { x: 3, y: 47, type: "hv" },
                { x: 4, y: 42, type: "hv" },
                { x: 5, y: 48, type: "hv" },
                { x: 1, y: 35, type: "hvh" },
                { x: 2, y: 30, type: "hvh" },
                { x: 3, y: 37, type: "hvh" },
                { x: 4, y: 32, type: "hvh" },
                { x: 5, y: 38, type: "hvh" },
                { x: 1, y: 25, type: "vhv" },
                { x: 2, y: 20, type: "vhv" },
                { x: 3, y: 27, type: "vhv" },
                { x: 4, y: 22, type: "vhv" },
                { x: 5, y: 28, type: "vhv" }
            ]
        };
    },
    // 方法集合
    methods: {
        initComponent() {
            // 此函数为个人习惯,喜欢创建一个初始化的函数
            this.msg = "vue-cli案例";
            const chart = new G2.Chart({
                container: "c1",
                width: 600,
                height: 300
            });
            chart.source(this.data);
            chart
                .line()
                .position("x*y")
                .color("type");
            this.chart = chart;
            this.chart.render();
        }
    },
    // 计算属性
    computed: {}
};
</script>
