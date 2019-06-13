const path = require("path");

module.exports = {
    outputDir: path.resolve(__dirname, "../webapp"),
    publicPath: '/government',
    devServer: {
        proxy: 'http://localhost:8080'
    },
}
