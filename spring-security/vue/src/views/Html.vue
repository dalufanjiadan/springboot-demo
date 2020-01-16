<template>
    <div class="section">
        <a :href="`${publicPath}html/test.html`">href</a>

        <div class="columns">
            <div class="column is-half">
                <pre>
                    <Prism language="html">
&lt;h1&gt;hello world&lt;/h1&gt;
&lt;p&gt; fasdfasdfasdfas &lt;/p&gt;
                    </Prism>
                </pre>
            </div>
            <div class="column  is-half">
                <h1>hello world</h1>
                <hr>
                <p>fasdfasdfasdfas</p>
            </div>
        </div>

        <pre>
             <Prism language="js">
let i = 10;
let i = 10;
let i = 10;
            </Prism>
        </pre>
    </div>
</template>

<script>
import "prismjs/prism";
import "prismjs/themes/prism.css";
import "prismjs/components/prism-java";
import Prism from "vue-prism-component";

export default {
    data() {
        return {
            publicPath: process.env.BASE_URL
        };
    },
    components: {
        Prism
    },
    methods: {
        onTestBtn: function() {
            console.log("hello world");
            let hello = "hello";
        }
    }
};
</script>

<style>
.number {
    padding: 0%;
    margin: 0%;
    min-height: auto;
    height: auto;
    min-width: auto;

    width: auto;
    line-height: 1.5;
    /* background-color: aquamarine; */
    font-size: 1em;
}
pre{
    /* padding: 0%; */
}
</style>
