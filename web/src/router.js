/* eslint-disable */
import Vue from 'vue'
import Router from 'vue-router'

import login from '../src/components/login'
import admin from '../src/components/admin/admin'
import engine from '../src/components/admin/engine'
import detail from '../src/components/admin/detail'


Vue.use(Router)

//获取原型对象上的push函数
const originalPush = Router.prototype.push
//修改原型对象中的push方法
Router.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}

const router =  new Router({
  mode: "history",
  routes: [
    {
      //主页
      path: '/',
      redirect:'/login'
    },
    {
      //登陆
      path: '/login',
      name: 'login',
      component: login
    },
    {
      //管理员界面
      path:'/admin',
      name:'admin',
      component:admin
    },
    {
      //二级页面
      path:'/engine',
      name:'engine',
      component:engine
    },
    {
      //详情页面
      path:'/detail',
      name:'detail',
      component:detail
    }
  ]
})

//配置路由拦截
router.beforeEach((to, from, next) => {
  const isLogin = sessionStorage.principal ? true : false;
  //路由拦截
  if (to.path == "/login") {
    next();
  } else {
    isLogin ? next() : next("/login");
  }
  next()
});

export default router;

