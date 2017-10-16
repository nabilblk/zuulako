const path = require('path');
const merge = require('webpack-merge');
const webpack = require('webpack');
const express = require('express');

const TARGET = process.env.npm_lifecycle_event;
const PATHS = {
    output: path.join(__dirname, '/target/classes/static')
};



var common = {
        entry: "./src/main/app/index.jsx",
        output: {
            path: PATHS.output,
            publicPath: '',
            filename: 'bundle.js'
        },
        resolve: {
            modules: [
                path.join(__dirname, "./src/main/app"),
                "node_modules"
            ],
            extensions: ['.js', '.jsx'],
            enforceExtension: false
        },

        plugins: [
            new webpack.NamedModulesPlugin()
        ],

        module: {
            rules: [{
                test: /\.js/,
                exclude: /node_modules/,
                loader: "babel-loader",
                include: [__dirname],
                options: {
                    presets: ["env", "react"]
                }
            }]
        }
    }


if (TARGET === 'start') {
    console.log('Compiling front end code for dev ')

    // Add Hot reload for dev env
    common.module.rules[0].options.presets.push("react-hmre")

    module.exports = merge(common, {
        devServer: {
            port: 9090,
            publicPath: 'http://localhost:9090/',
            historyApiFallback: true,
            before(app){
                let join = path.join(__dirname, '/src/main/resources/static');
                console.log(join)
                app.use(express.static(join))
            }
        },
        devtool: 'source-map'
    });

}

if (!TARGET || TARGET==='build') {
    console.log('Compiling front end code for production ')

    module.exports = merge(common, {});
}

