const webpack = require("webpack");
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const app = {
  entry: [
    __dirname + '/src/main/resources/static/js/main.js',
    __dirname + '/src/main/resources/static/js/bulma.js'
  ],
  output: {
    path: __dirname + '/src/main/resources/static/dist',
    filename: './js/bundle.min.js'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015']
        }
      },
      {
        test: /\.s[ac]ss$/,
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: [
            { loader: 'css-loader', options: { minimize: true } },
            { loader: 'sass-loader' },
          ]
        })
      }
    ]
  },
  plugins: [
    new webpack.optimize.UglifyJsPlugin(),
    new ExtractTextPlugin('css/bulma.min.css')
  ]
};

// module.exports = [app, bulma];
module.exports = app;

