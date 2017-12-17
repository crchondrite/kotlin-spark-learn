module.exports = {
  context: __dirname + '/src/main/resources/static',
  entry: {
    js: './js/main.js'
  },
  output: {
    path: __dirname + '/src/main/resources/static/dist',
    filename: './js/bundle.js'
  },

  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015']
        }
      }
    ]
  }
};
