const path = require("path");

module.exports = {
    outputDir: path.resolve(__dirname, "../src/main/resources/static"),
    runtimeCompiler:true
    // 好像用不到
    // assetsDir: path.resolve(__dirname, "../src/main/resources/static")
};
