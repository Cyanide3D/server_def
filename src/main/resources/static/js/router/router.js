import Vue from 'vue'
import VueRouter from 'vue-router'
import MemberList from 'pages/statistic/List.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: MemberList },
    // { path: '/auth', component: Auth },
    // { path: '/profile', component: Profile },
    { path: '*', component: MemberList }
]

export default new VueRouter({
    mode: 'history',
    routes
})
