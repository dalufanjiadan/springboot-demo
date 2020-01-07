<template>
    <div class="section">
        <Demo></Demo>
        <hr />
        <Income></Income>
        <hr />
        <Area></Area>
    </div>
</template>

<script>
import Income from "../components/antv/live/Income";
import Demo from "../components/antv/g2/Demo";
import Area from "../components/antv/g2/Area";

export default {
    data() {
        return {};
    },
    components: {
        Income,
        Demo,
        Area,
    }
};
</script>

<style></style>
