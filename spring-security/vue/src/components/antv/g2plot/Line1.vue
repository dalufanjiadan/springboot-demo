<template>
    <div class="section">
        <div id="canvas"></div>
        <button class="button is-primary" @click="testBtnOnClick">
            test
        </button>
    </div>
</template>

<script>
import { Line } from "@antv/g2plot";
export default {
    data() {
        return {
            lineData: null,
            linePlot: null
        };
    },
    mounted() {
        // this.render();
    },
    created() {
        this.$Axios
            .get(
                "/game/live/incomeLine?dateThird=2019-12-22&gameId=94&opGameId=all&serverId=all&timeRange=hour"
            )
            .then(response => {
                this.lineData = response.data.data;
            });
    },
    methods: {
        render() {
            const data = this.lineData;

            console.log("================");
            console.log(data);
            console.log("================");
            if (this.linePlot !== null) {
                console.log("--==");
                console.log(typeof this.linePlot);
                console.log();
                this.linePlot.destroy();
                console.log("--==");
            }

            this.linePlot = new Line("canvas", {
                data,
                xField: "dateTime",
                yField: "value",
                seriesField: "date"
            });

            this.linePlot.render();
        },
        testBtnOnClick: function() {
            console.log("--==");
            console.log(typeof this.linePlot);
            console.log(Object.keys(this.linePlot));
            this.linePlot.clear();
            console.log("--==");
        }
    },
    watch: {
        lineData: {
            handler(newLineData, oldLineData) {
                this.render();
            },
            deep: true
        }
    }
};
</script>

<style></style>
