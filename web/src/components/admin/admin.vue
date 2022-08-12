<!-- eslint-disable -->
<template>
    <div id="admin">
        <el-container>
            <el-container >
                <el-aside width='200px'>
                    <el-menu default-active="1" class="el-menu-vertical-demo"  background-color="#545c64"
                        text-color="#fff" active-text-color="#ffd04b" style="height:850px" @select="choice">
                        <el-menu-item index="1" >
                            <span class="menuItem"><i class="el-icon-user-solid"></i></span>
                            <span class="menuItemTitle" slot="title">车辆管理</span>
                        </el-menu-item>
                        <el-menu-item index="2" >
                            <span class="menuItem"><i class="el-icon-user-solid"></i></span>
                            <span class="menuItemTitle" slot="title">用户管理</span>
                        </el-menu-item>
                        
                    
                    </el-menu>
                </el-aside>

                <el-main>
                     <!-- <nav-header :index="index"></nav-header> -->
                     <nav-header :index="index"></nav-header>
                     <user-manage v-if="index.name=='用户管理'"></user-manage>
                     <car-manage v-if="index.name=='车辆管理'"></car-manage>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import NavHeader from '../public/navHeader.vue'
import CarManage from './carManage.vue'
/* eslint-disable */ 
import UserManage from './userManage.vue'
export default {
  components: {UserManage, NavHeader, CarManage},
    data(){
        return{
            manageType:1,
            userInfo:{},
            navs:[],
            currentUser:{},
            index:{},
            indexs:[
                {name:'车辆管理',path:'/car',index:'1'},
                {name:'用户管理',path:'/user',index:'2'},
            ]
        }
    },

    methods:{
        choice(val){
            this.index = (this.indexs.filter(item => {return item.index == val}))[0]
            
        }
    },
    created(){
        document.title="管理端"
        if(sessionStorage.getItem('principal')!=null){
            this.currentUser = JSON.parse(sessionStorage.getItem('principal'))
            this.index = (this.indexs.filter(item => {return item.index == '1'}))[0]
        }else{
            this.$router.push({'path':'/login'})
        }
    }
}
</script>

<style scoped>
    .title{
        font-size: 13px;
        font-weight: bolder;
        opacity: 0.8;
    }
    
    .exit{
        cursor: pointer;
    }
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
  
  .el-aside {
    /* background-color: #D3DCE6; */
    color: #333;
    text-align: center;
    height: 850px;
 
  }
  
  .el-main {
    /* background-color: #E9EEF3; */
    color: #333;
    text-align: center;
    height: 850px;
  }
  
  /* body > .el-container {
    margin-bottom: 40px;
  } */
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .menuItem{
    margin-left:-50px;
    margin-right:20px;
  }
  .menuItemTitle{
    font-size: 15px;
    font-weight:bold;
  }
</style>