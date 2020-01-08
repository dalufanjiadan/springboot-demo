<template>
    <div class="section">
        <Demo></Demo>
        <hr />
        <Income></Income>
        <hr />
        <Line1></Line1>
    </div>
</template>

<script>
import Income from "../components/antv/live/Income";
import Demo from "../components/antv/g2/Demo";
import Area from "../components/antv/g2/Area";
import Line1 from "../components/antv/g2plot/Line1";

export default {
    data() {
        return {};
    },
    components: {
        Income,
        Demo,
        Area,
        Line1
    }
};
</script>

<style></style>
