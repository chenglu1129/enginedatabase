/* eslint-disable */
<template>
    <div id="login">
        <img :src="require('../assets/login.webp')" width="100%" height="100%"/>
        <div class="loginDiv">
            <h2>发动机载体系统登陆</h2>
            <el-form :model="loginForm" ref="loginForm" :rules="rules">
                <el-form-item prop="account">
                    <el-input v-model="loginForm.account" >
                        <template slot="prepend">账号</template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" >
                        <template slot="prepend">密码</template>
                    </el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" style="width:320px" @click="login">登陆</el-button>
        </div>
    </div>
</template>

<script>
/* eslint-disable */
export default {
    data(){
        return{
            loginForm:{},
            rules:{
                account: [{ required: true, message: '请输入账号', trigger: 'change' }],
                password: [{ required: true, message: '请输入密码', trigger: 'change' }],
            }
        }
    },
    methods:{
        login(){
            this.$refs['loginForm'].validate((valid) => {
                if (valid) {
                    this.$http.http_post(this,this.$api.login.loginSubmit,this.loginForm,true,(res)=>{
                       console.log(res)
                        if(res.code == 1){
                            sessionStorage.setItem('principal',JSON.stringify(res.data.principal))
                            this.$router.push({'path':'/admin'})
                        }
                    })
                } 
            });
        }
    }
}
</script>

<style scoped>
/* eslint-disable */
    .loginDiv{
        position: absolute;
        top: 10%;
        left: 35%;
        width: 500px;
        margin: 0 auto;
        margin-top: 100px;
        padding: 10px 10px 35px 10px;
        background-color: rgb(199, 225, 238);
        opacity: 0.8;
        padding: 30px;
    }

    #login{
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        overflow-y: auto;
    }

    .reg{
        margin-top: 10px;
    }
    .reg a{
        font-size: 14px;
        text-decoration: none;
        color: black;
    }
</style>