const path = require('path'); // 引入path(NodeJS自带)模块用于构建路径
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');
module.exports = {
    entry: './src/index.js', //入口文件是index.js
    output: {
        filename: "bundle.js",
        path: path.resolve(__dirname, "dist"),
    },

    module: {
        rules: [
            {test: /\.(js)$/, use:'babel-loader'}, // loader 是从右向左执行的
            {test: /\.(html)$/, use:['html-loader']},
            {test: /\.(css)$/, use:['style-loader', 'css-loader']},

        ]

    },
    mode:'development',
    plugins: [new HtmlWebpackPlugin({template : './src/index.html'}), new webpack.ProvidePlugin({
        $: "jquery",
        jQuery: "jquery",
        "window.jQuery": "jquery"
    })],
    //现在的写法需要解构赋值，然后不接受任何arg    , new CleanWebpackPlugin()
}
