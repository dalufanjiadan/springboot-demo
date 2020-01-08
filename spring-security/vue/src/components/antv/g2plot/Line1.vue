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
    mounted() {},
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
        testBtnOnClick: function() {
        }
    },
    watch: {
        lineData: {
            handler(newLineData, oldLineData) {
                if (this.linePlot !== null) {
                    this.linePlot.changeData(this.lineData);
                    this.linePlot.clear();
                } else {
                    // 为什么不能直接传newLineData呢
                    const data = newLineData;

                    this.linePlot = new Line("canvas", {
                        data,
                        xField: "dateTime",
                        yField: "value",
                        seriesField: "date"
                    });
                }
                this.linePlot.render();
            },
            deep: true
        }
    }
};
</script>

<style></style>
