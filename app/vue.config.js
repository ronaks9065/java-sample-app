module.exports = {
  devServer: {
    contentBase: './public',
    proxy: {
      '/confluence': {
        target: 'http://localhost:1990'
      }
    }
  },
  publicPath:
      process.env.NODE_ENV === "prod" ? "/wikis/dpn/" : "/confluence/dpn",
  outputDir: "../target/classes/webapp",
  //lintOnSave: true,
  //filenameHashing: false,
  //chainWebpack: config => {
  //  config.optimization.delete('splitChunks')
  //}
};
