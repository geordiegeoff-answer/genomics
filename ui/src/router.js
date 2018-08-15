import Vue from 'vue'
import VueRouter from 'vue-router'
import GMap from './components/GMap'

Vue.use(VueRouter);

const routes = [
    { name: 'Home', path: '*', component: GMap }
]
export default new VueRouter({
    routes
})