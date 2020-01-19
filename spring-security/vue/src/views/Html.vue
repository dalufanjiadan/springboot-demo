<template>
    <div class="section">
        <a :href="`${publicPath}html/test.html`">href</a>

        <div class="columns">
            <div class="column is-half">
                <pre>
                    <Prism language="html">{{htmlCode}}</Prism>
                </pre>
            </div>
            <div class="column  is-half">
                <header>
                    <div id="logo">HTML</div>
                    <nav>
                        <ul>
                            <li><a href="/">Home</a></li>
                            <li><a href="/link">Page</a></li>
                        </ul>
                    </nav>
                </header>
                <article>
                    <h2>Title 1</h2>
                    <p>Content 1</p>
                </article>
                <article>
                    <h2>Title 2</h2>
                    <p>Content 2</p>
                </article>
                <section>A group of related content</section>
                <aside>Sidebar</aside>
                <footer>
                    <p>&copy; HTML CheatSheet</p>
                    <address>Contact <a href="mailto:me@htmlg.com">me</a></address>
                </footer>
            </div>
        </div>

        <div class="columns">
            <div class="column is-half">
                <pre>
                    <prism language="css">
a{
    background-color:#fff;
}
                    </prism>
                </pre>
            </div>
            <div class="column is-half"></div>
        </div>

        <pre>
             <Prism language="js">
let i = 10;
let i = 10;
let i = 10;
            </Prism>
        </pre>

        <button class="button is-primary" @click="testBtnClick">test</button>
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
            publicPath: process.env.BASE_URL,
            htmlCode: `<header>
    <div id="logo">HTML</div>
    <nav>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/link">Page</a></li>
        </ul>
    </nav>
</header>
<article>
    <h2>Title 1</h2>
    <p>Content 1</p>
</article>
<article>
    <h2>Title 2</h2>
    <p>Content 2</p>
</article>
<section>A group of related content</section>
<aside>Sidebar</aside>
<footer>
    <p>&copy; HTML CheatSheet</p>
    <address>Contact <a href="mailto:me@htmlg.com">me</a></address>
</footer>
`
        };
    },
    components: {
        Prism
    },
    methods: {
        testBtnClick: function() {
            console.log("hello world");
            let hello = "hello";
            this.readFile("..../public/html/test.html")
        },
        readFile: function(file) {

            console.log(object);
            
            // var rawFile = new XMLHttpRequest();
            // rawFile.open("GET", file, false);
            // rawFile.onreadystatechange = function() {
            //     if (rawFile.readyState === 4) {
            //         if (rawFile.status === 200 || rawFile.status == 0) {
            //             var allText = rawFile.responseText;
            //             alert(allText);
            //         }
            //     }
            // };
            // rawFile.send(null);
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
pre {
    /* padding: 0%; */
}
</style>
