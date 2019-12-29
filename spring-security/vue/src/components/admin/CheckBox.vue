<template>
    <section>
        <b-checkbox :native-value="nativeValue">{{ nativeValue }} </b-checkbox>
        <div class="is-clearfix"></div>
    </section>
</template>

<script>
export default {
    props: ["nativeValue"]
};
</script>

<style></style>
