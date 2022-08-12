<!--eslint-disable -->
<template>
    <div id="carManage">
        <el-col :span="20" class="toolbar">
			<el-form :inline="true" :model="searchForm">
				<el-form-item>
					<el-button type="primary" size="mini" @click="add" icon="el-icon-plus">新增</el-button>
				</el-form-item>
			</el-form>
		</el-col>
        
        <!--列表-->
		<el-table class="myTable" :data="datas" highlight-current-row   stripe  style="width: 100%;font-size: 13px;"
            :header-cell-style="{background:'#87CEFA',color:'#606266',fontSize:'13px', textAlign:'center'}" >
			<el-table-column type="index" width="50" align="center">
			</el-table-column>
			<el-table-column prop="account" label="账号" align="center" width="120" >
			</el-table-column>
			<el-table-column prop="realName" label="姓名" align="center" width="120" >
			</el-table-column>
			
			<el-table-column prop="nickName" label="昵称" align="center" width="150">
			</el-table-column>
			<el-table-column prop="phone" label="电话" align="center" width="150">
			</el-table-column>
			<el-table-column prop="subTime" label="注册时间" align="center">
			</el-table-column>
            <el-table-column prop="type" label="用户角色" align="center" width="120">
			</el-table-column>
			<el-table-column label="操作" width="180">
				<template slot-scope="scope">
					<el-button  size="mini" @click="edit(scope.row)" icon="el-icon-edit">编辑</el-button>
					<el-button type="danger" size="mini" @click="del(scope.row)" icon="el-icon-delete">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

        <!--工具条-->
		<div class="page">
			<el-pagination
				v-if="datas.length > 0"
					background
					layout="prev, pager, next"
					@current-change="pageChange"
					:current-page="searchForm.page"
					:page-size="searchForm.pageSize"
					:total="searchForm.total"
					class="fr"
			></el-pagination>
		</div>

        <el-dialog :title="dialog.title" :close-on-click-modal="false" :visible.sync="dialog.show" :width="dialog.width">
			<el-form :model="publishForm"   ref="publishForm" :rules="rules" label-width="80px" label-position="left">
                <el-row :gutter='30'>
                    <el-col :span='12'>
                        <el-form-item label="账号" prop="account">
                            <el-input v-model="publishForm.account" placeholder="请输入账号" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label="昵称" prop="nickName" >
                            <el-input v-model="publishForm.nickName" placeholder="请输入昵称" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label="邮箱">
                            <el-input v-model="publishForm.email" placeholder="请输入邮箱" style="width:100%"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="姓名" prop="realName">
                            <el-input v-model="publishForm.realName" placeholder="请输入姓名" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label="电话" prop="phone" style="margin-left:10px">
                            <el-input v-model="publishForm.phone" placeholder="请输入电话" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label="角色" prop="type">
                            <el-select v-model="publishForm.type"  style="width:100%">
                                <el-option v-for="(item,index) in roles" :key="index" :value="item" :label="item"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
					
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialog.show = false" size="mini">取消</el-button>
				<el-button type="primary" @click="publish" size="mini">提交</el-button>
			</div>
		</el-dialog>
    </div>
</template>

<script>
/* eslint-disable */ 
export default {
    data(){
        return{
            searchForm:{
                page:1,
                pageSize:5,
                total:0,
            },
            datas:[],
            dialog:{
                title:'新增用户',
                width:'60%',
                show:false
            },
            publishForm:{},
            rules:{
                account:[{required: true,message: "账号不能为空",trigger: "blur"}],
                realName:[{required: true,message: "姓名不能为空",trigger: "blur"}],
                gender:[{required: true,message: "性别不能为空",trigger: "blur"}],
                roleSerial:[{required: true,message: "角色不能为空",trigger: "blur"}],
            },
            roles:['管理员','普通用户'],
            
        }
    },
    methods:{
        
        //加载查询表格
        loadSearch(){
            this.datas = []
            this.$http.http_post(this,this.$api.user.findCondition,this.searchForm,false,(res)=>{
                if(res.code == 1){
                    this.datas = res.data
                    this.searchForm.total = res.count
                }
            })
        },

        doSearch(){
            this.searchForm.page = 1
            this.loadSearch()
        },
        //分页
        pageChange(page){
            this.searchForm.page = page
            this.loadSearch()
        },
        add(){
            let user = JSON.parse(sessionStorage.getItem('principal'))
            if(user.type == '普通用户'){
                this.$message.error('当前用户无权操作')
                return
            }
            this.dialog.title='新增用户',
            this.dialog.show = true
        },
        edit(row){
            this.publishForm = row
            this.dialog.title='修改用户',
            this.dialog.show = true
        },

        
        del(row){
            let user = JSON.parse(sessionStorage.getItem('principal'))
            if(user.type == '普通用户'){
                this.$message.error('当前用户无权操作')
                return
            }
            this.$confirm('此操作将永久删除记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$http.http_get(this,this.$api.user.remove.replace(/{serial}/,row.serial),null,true,(res)=>{
                    if(res.code == 1){
                        this.loadSearch()
                    }
                })
            }).catch(() => {
                      
            });
        },

        //提交表单
        publish(){
            this.$refs["publishForm"].validate(valid => {
				if (valid) {
					this.$http.http_post(this,this.$api.user.publish,this.publishForm,true,(res)=>{
                        if(res.code == 1){
                            this.loadSearch()
                            this.dialog.show = false
                        }
                    })			
				}
			});
        }

    },
    created(){
        this.loadSearch()
    }
}
</script>

<style scoped>
/* eslint-disable */
    .toolbar{
       width: 100%;
       text-align: left;
    }
    .page{
        float: right;
        margin-top: 15px;
    }
    /deep/ .el-table th {
        border: 1px solid #dfe6ec;
    }
    /deep/ .el-table td {
        border: 1px solid #dfe6ec;
        color: black;
    }
    /deep/ .el-table__empty-block {
        border-left: 1px solid #dfe6ec;
        border-top: 1px solid #dfe6ec;
    }
    .el-table{
        color: black;
        border-right: 1px solid #dfe6ec;
        border-bottom: 1px solid #dfe6ec;
    }
</style>