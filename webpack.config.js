const webpack = require('webpack');
const path = require('path');
const isProd = false; //set true for production

module.exports = function(){
    //Create vendor bundle
    plugins = [
        new webpack.optimize.CommonsChunkPlugin({
            name: 'vendor',
            filename: './src/main/resources/static/js/vendor.bundle.js',
            minChunks: Infinity,
        })
    ];
    //Minification for production
    if (isProd) {
        plugins.push(
            new webpack.LoaderOptionsPlugin({
                minimize: true,
                debug: false
            }),
            new webpack.optimize.UglifyJsPlugin({
                compress: {
                    warnings: false
                }
            })
        )
    }else {
        plugins.push(
            new webpack.LoaderOptionsPlugin({
                debug: true
            })
        );
    }
    return {
        entry: {
            app: './src/main/js/app.js',
            vendor: [
                'whatwg-fetch',
                'react',
                'react-dom',
                'react-router',
                'react-loader',
                'react-bootstrap',
                'babel-polyfill'
            ]
        },
        devtool:  isProd ? 'source-map' : 'eval',
        output: {
            path: __dirname,
            filename: './src/main/resources/static/js/bundle.js'
        },
        module: {
            rules: [
                {
                    test: /\.jsx?$/,
                    exclude: [/node_modules/],
                    use: [{
                        loader: 'babel-loader',
                        options: {
                            presets: ['es2015', 'react', 'stage-2'],
                            plugins: ['transform-decorators']
                        }
                    }],
                }
            ]
        },
        plugins
    };
};
