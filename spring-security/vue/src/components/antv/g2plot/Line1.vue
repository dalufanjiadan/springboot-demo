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
                //

                let data = response.data.data;
                let dataToday = [];
                let dataYesterday = [];
                let dataThird = [];
                // "".
                data.forEach(element => {
                    element.dateTime = element.dateTime.slice(0,2);
                    if (element.date === "今日") {
                        dataToday.push(element);
                    } else if (element.date === "昨日") {
                        dataYesterday.push(element);
                    } else {
                        // dataThird.push(element);
                    }
                });

                this.lineData = [];
                for (let index = 0; index < dataYesterday.length; index++) {
                    if (index < dataToday.length) {
                        // this.lineData.push(dataToday[index]);
                    }
                    this.lineData.push(dataYesterday[index]);
                    // this.lineData.push(dataThird[index]);
                }

                // this.lineData = response.data.data;
            });
    },
    methods: {
        testBtnOnClick: function() {}
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
                        // xField: "timeInSeconds",
                        xField: "dateTime",
                        yField: "value",
                        seriesField: "date",
                        xAxis: {
                            // type: "timeCat",
                            autoHideLabel: true
                        }
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
