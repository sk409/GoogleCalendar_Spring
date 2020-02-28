const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const VueLoaderPlugin = require("vue-loader/lib/plugin");

const jsSrcDir = "./src/main/resources/js/";

module.exports = (env, args) => {
  const devmode = args.mode === "development";
  return {
    devtool: devmode ? "source-map" : "none",
    entry: {
      app: jsSrcDir + "app.js",
      login: jsSrcDir + "login.js",
      register: jsSrcDir + "register.js"
    },
    module: {
      rules: [
        {
          test: /\.vue$/,
          loader: "vue-loader"
        },
        {
          test: /\.js$/,
          exclude: /(node_modules|bower_components)/,
          use: {
            loader: "babel-loader",
            options: {
              presets: ["@babel/preset-env"]
            }
          }
        },
        {
          test: /\.css$/,
          use: ["style-loader", "vue-style-loader", "css-loader"]
        },
        {
          test: /\.scss/,
          use: [MiniCssExtractPlugin.loader, "css-loader", "sass-loader"]
        }
      ]
    },
    output: {
      filename: "[name].js",
      path: __dirname + "/src/main/resources/static/js"
    },
    plugins: [
      new MiniCssExtractPlugin({
        filename: "../css/[name].css"
      }),
      new VueLoaderPlugin()
    ],
    resolve: {
      extensions: [".js", ".vue"],
      alias: {
        vue$: "vue/dist/vue.esm.js"
      }
    }
  };
};
