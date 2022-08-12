<!-- eslint-disable -->
<template>
    <div id="navHeader">
        <div class="guide">
            <i class="el-icon-guide"></i>
        </div>
        
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/admin'}">首页</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: index.path }" >{{ index.name }}</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="userDiv">
            <el-dropdown>
                <span class="el-dropdown-link">
                    {{cur.realName}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <div @click="exit"> 
                        <el-dropdown-item >退出</el-dropdown-item>
                    </div>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
/* eslint-disable */
export default {
    props:['index'],
    data(){
        return{
            cur:{}
        }
    },
    methods:{
        //退出
        exit(){
             this.$confirm('是否退出?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    sessionStorage.clear()
                    this.$router.push({path:'/login'})
                }).catch(() => {
                          
            });
        },
        currentUser(){
            this.cur = JSON.parse(sessionStorage.getItem('principal'))
            console.log(this.cur)
        }
    },
    created(){
        this.currentUser()

    }
}
</script>

<style scoped>
/* eslint-disable */
    #navHeader{
        /* border: 1px solid red; */
        height: 50px;
        width: 100%;
        margin-top: -15px;
        padding: 5px;
        display: flex
    }
    .breadcrumb{
        /* border: 1px solid rgb(26, 26, 24); */
        height: 25px;
        width: 200px;
        padding: 1px;
        margin-left: 25px;
        padding-top: 18px;
    }
    .guide{
        float: left;
        line-height: 50px;
        height: 45px;
        /* border: 1px solid red; */
        font-size: 20px;
    }
    .userDiv{
        height: 50px;
        line-height: 50px;
        width: 120px;
        margin-left: 950px;
    }
    .el-dropdown-link {
        cursor: pointer;
        color: #409EFF;
    }
    .el-icon-arrow-down {
        font-size: 15px;
    }
</style>