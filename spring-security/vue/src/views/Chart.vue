<template>
    <section class="section">
        <ve-line :data="chartData" :settings="chartSettings"></ve-line>
        <b-button @click="update"> update </b-button>
    </section>
</template>

<script>
export default {
    data() {
        this.chartSettings = {
            metrics: ["访问用户", "下单用户"],
            dimension: ["日期"]
        };
        return {
            chartData: {
                columns: ["日期", "访问用户", "下单用户", "下单率"],
                rows: [
                    { 日期: "1/1", 访问用户: 1393, 下单用户: 1093, 下单率: 0.32 },
                    { 日期: "1/2", 访问用户: 3530, 下单用户: 3230, 下单率: 0.26 },
                    { 日期: "1/3", 访问用户: 2923, 下单用户: 2623, 下单率: 0.76 },
                    { 日期: "1/4", 访问用户: 1723, 下单用户: 1423, 下单率: 0.49 },
                    { 日期: "1/5", 访问用户: 3792, 下单用户: 3492, 下单率: 0.323 },
                    { 日期: "1/6", 访问用户: 4593, 下单用户: 4293, 下单率: 0.78 }
                ]
            }
        };
    },
    methods: {
        update: function() {
            this.chartData.columns = ["date", "dateTime", "value", "timeInSeconds"];
            this.chartData.rows = null;
            this.chartSettings.dimension = ["dateTime"];
            this.chartSettings.dimension = ["dateTime"];
            this.$Axios
                .get(
                    "/game/live/incomeLine?dateThird=2019-12-22&gameId=94&opGameId=all&serverId=all&timeRange=minute"
                )
                .then(response => {
                    let data = response.data.data;
                    // console.log(Object.keys(data[0]))
                    this.chartData.rows = data;
                });
        }
    }
};
</script>

<style></style>
