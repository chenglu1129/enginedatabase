<template>
    <div id="register">
        <img :src="require('../assets/login.webp')" width="100%" height="100%"/>
        <div class="registerDiv">
            <h2 style="opacity:0.8">用户注册</h2>
            <el-form :model="loginForm" ref="loginForm" :rules="rules">
                <el-form-item prop="account">
                    <el-input v-model="loginForm.account" style="width:320px" >
                        <template slot="prepend">账号</template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" style="width:320px">
                        <template slot="prepend">密码</template>
                    </el-input>
                </el-form-item>
                
                <el-form-item>
                    <el-input v-model="loginForm.nickName" style="width:320px">
                        <template slot="prepend">昵称</template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="phone">
                    <el-input v-model="loginForm.phone" style="width:320px">
                        <template slot="prepend">手机号码</template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="loginForm.email" style="width:320px">
                        <template slot="prepend">邮箱</template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="loginForm.realName" style="width:320px">
                        <template slot="prepend">真实姓名</template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="gender">
                    <el-radio-group v-model="loginForm.gender" style="width:320px">
                        <el-radio label="1">男</el-radio>
                        <el-radio label="2">女</el-radio>
                    </el-radio-group>
                </el-form-item>
                
            </el-form>
            <el-button type="danger" style="width:320px" @click="register">注册</el-button>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            loginForm:{},
            radio:'1',
            rules:{
                account: [{ required: true, message: '请输入账号', trigger: 'change' }],
                password: [{ required: true, message: '请输入密码', trigger: 'change' }],
                phone: [{ required: true, message: '请填写电话号码', trigger: 'change' }],
                gender: [{ required: true, message: '性别不能为空', trigger: 'change' }],
            }
        }
    },
    methods:{
        register(){
            this.$refs['loginForm'].validate((valid) => {
                if (valid) {
                   this.$http.http_post(this,this.$api.login.registSubmit,this.loginForm,true,(res)=>{
                       if(res.code == 1){
                           setInterval(()=>{
                               this.$router.push({path:'/login'})
                           },3000)
                       }
                   })
                } 
            });
        }
    }
}
</script>
<style scoped>

    #register{
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        overflow-y: auto;
    }
     .registerDiv{
        position: absolute;
        top: 0%;
        left: 35%;
        width: 500px;
        margin: 0 auto;
        margin-top: 100px;
        padding: 10px 10px 35px 10px;
        background-color: rgb(199, 225, 238);
        opacity: 0.8;

    }

    /deep/ .el-form-item__error{
        margin-left: 90px;
    }
    
</style>
