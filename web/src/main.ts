import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/reset.css'
import * as Icons from '@ant-design/icons-vue'
import axios from 'axios'

axios.defaults.baseURL = process.env.VUE_APP_API_URL;

const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app');

const icons: any = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

console.log('环境:',process.env.NODE_ENV);

//写一个axios拦截器，分别打印请求参数，返回结果和返回错误信息
axios.interceptors.request.use(function (config) {
    console.log('请求参数:', config);
    return config;
}, function (error) {
    console.log('请求错误:', error);
    return Promise.reject(error);
});


axios.interceptors.response.use(function (response) {
    console.log('返回结果:', response);
    return response;
}, function (error) {
    console.log('返回错误:', error);
    return Promise.reject(error);
});


