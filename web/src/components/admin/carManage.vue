<!--eslint-disable -->
<template>
    <div id="userManage">
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
			<el-table-column  type="index" width="50" align="center">
			</el-table-column>
            
			<el-table-column prop="cName" label="车辆名称" align="center" width="120" >
			</el-table-column>
            <el-table-column prop="cName" label="载体号" align="center" width="120" >
                <template slot-scope="scope" v-if="scope.row.engineCarrier.no!=null">
                    <el-tag type='danger'>{{scope.row.engineCarrier.no}}</el-tag>
                </template>
			</el-table-column>
            <el-table-column prop="engineCarrier" label="维修时间" align="center" width="120" >
                <template slot-scope="scope" v-if="scope.row.engineCarrier.ecRepairtime!=null">
                    <el-tag type='success'>{{scope.row.engineCarrier.ecRepairtime}}</el-tag>
                </template>
			</el-table-column>
			<el-table-column prop="engineCarrier" label="载体" align="center" width="120" >
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.engineCarrier,'发动机载体')">维修</el-button>
                </template>
			</el-table-column>
			
			<el-table-column prop="frontRudder" label="前舵" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.frontRudder,'前舵')">维修</el-button>
                </template>
			</el-table-column>

			<el-table-column prop="leftFrontWheel" label="左前轮" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.leftFrontWheel,'左前轮')">维修</el-button>
                </template>
			</el-table-column>

			<el-table-column prop="leftRearWheel" label="左后轮" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.leftRearWheel,'左后轮')">维修</el-button>
                </template>
			</el-table-column>

            <el-table-column prop="rearRudder" label="后舵" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.rearRudder,'后舵')">维修</el-button>
                </template>
			</el-table-column>

            <el-table-column prop="rightFrontWheel" label="右前轮" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.rightFrontWheel,'右前轮')">维修</el-button>
                </template>
			</el-table-column>

			<el-table-column prop="rightRearWheel" label="右后轮" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.rightRearWheel,'右后轮')">维修</el-button>
                </template>
			</el-table-column>

            <el-table-column prop="backSkirt" label="护裙" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.backSkirt,'护裙')">维修</el-button>
                </template>
			</el-table-column>
            <el-table-column prop="silkSleeve" label="丝套" align="center" width="120">
                <template slot-scope="scope">
                    <el-button style="color:#e6a23c" type='text' @click="repair(scope.row.silkSleeve,'丝套')">丝套</el-button>
                </template>
			</el-table-column>

			<el-table-column label="操作" width="220" align="center">
				<template slot-scope="scope">
                    <el-button  type="info" plain size="mini" @click="look(scope.row)" icon="el-icon-search">查看</el-button>
					<el-button  type="danger" size="mini" @click="del(scope.row)" icon="el-icon-delete">删除</el-button>
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

        <!--新增车辆-->
        <el-dialog :title="dialog.title" :close-on-click-modal="false" :visible.sync="dialog.show" :width="dialog.width">
			<el-form :model="publishForm"   ref="publishForm" :rules="rules" label-width="80px" label-position="left">
                <el-row :gutter='40'>
                    <el-col :span='22'>
                        <el-form-item label='车辆名称'>
                            <el-input v-model="publishForm.cName" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label='载体号'>
                            <el-input v-model="publishForm.no" style="width:100%"></el-input>
                        </el-form-item>
                        <el-form-item label='载体图片'>
                            <el-upload
                                style="border:1px solid #d9d9d9;width:201px;height:181px"
                                class="avatar-uploader"
                                :action="this.$api.file.upload"
                                :show-file-list="false"
                                :on-success="handleAvatarSuccess"
                                >
                                <el-image v-if="imageUrl" :src="imageUrl" style="width: 200px; height: 180px" fit='fill'></el-image>
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                        </el-form-item>
                    </el-col>
                    
                </el-row>
                
            </el-form>
					
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialog.show = false" size="mini">取消</el-button>
				<el-button type="primary" @click="publish" size="mini">提交</el-button>
			</div>
		</el-dialog>

        <!--维修各部位-->
        <el-dialog :title="dialog_A.title" :close-on-click-modal="false" :visible.sync="dialog_A.show" :width="dialog_A.width">
			<el-form :model="repairForm"   ref="repairForm"  label-width="130px" label-position="left">
                <el-row :gutter='30'>
                    <el-col :span='18'>
                        <el-form-item label='维修时间'>
                            <el-date-picker
                                style="width:100%"
                                v-model="repairForm.time"
                                value-format='yyyy-MM-dd'
                                type="date"
                                placeholder="选择日期">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label='维修类型'>
                            <el-input v-model="repairForm.comment"></el-input>
                        </el-form-item>
                       <el-form-item label='最后一次维修时间'>
                            <el-input v-model="repairForm.lastTime" disabled></el-input>
                        </el-form-item>
                        <el-form-item label='图片' v-if="dialog_A.title=='发动机载体维修'">
                            <el-image  :src="repairForm.url_A" style="width: 180px; height: 160px;margin-left:-80px" fit='fill'></el-image>
                        </el-form-item>
                    </el-col>
                </el-row>              
            </el-form>
					
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialog_A.show = false" size="mini">取消</el-button>
				<el-button type="primary" @click="publishRepair" size="mini">提交</el-button>
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
                title:'',
                width:'40%',
                show:false
            },
            //维修弹框
            dialog_A:{
                title:'',
                width:'40%',
                show:false
            },
            publishForm:{},
            rules:{
                cName:[{required: true,message: "车辆名称不能为空",trigger: "blur"}],
            },
            //维修表单
            repairForm:{},
            imageUrl:''
        }
    },
    methods:{
        //上传成功回调
        handleAvatarSuccess(res,file){
            
            if(res.code == 1){
                this.publishForm.url = (res.data)[0].url
                this.imageUrl = (res.data)[0].url
            }
        },
        //加载查询表格
        loadSearch(){
            this.datas = []
            this.$http.http_post(this,this.$api.car.findCondition,this.searchForm,false,(res)=>{
               
                if(res.code == 1){
                    this.datas = res.data
                    this.datas.forEach(item => {
                        item.engineCarrier.lastTime = item.engineCarrier.ecRepairtime
                        item.frontRudder.lastTime = item.frontRudder.frRepairtime
                        item.leftFrontWheel.lastTime = item.leftFrontWheel.lfwRepairtime
                        item.leftRearWheel.lastTime = item.leftRearWheel.lrwRepairtime
                        item.rearRudder.lastTime = item.rearRudder.rrRepairtime
                        item.rightFrontWheel.lastTime = item.rightFrontWheel.rfwRepairtime
                        item.rightRearWheel.lastTime = item.rightRearWheel.rrwRepairtime
                        item.silkSleeve.lastTime = item.silkSleeve.ssRepairtime
                        item.backSkirt.lastTime = item.backSkirt.bsRepairtime
                    });
                    this.searchForm.total = res.count
                }

            })
        },
        
        //打开维修窗口
        repair(row,name){
            let user = JSON.parse(sessionStorage.getItem('principal'))
            if(user.type == '普通用户'){
                this.$message.error('当前用户无权操作')
                return
            }
            this.repairForm = {}
            this.dialog_A.title = name + '维修'
            this.repairForm.carSerial = row.carSerial
            this.repairForm.serial = row.serial
            this.repairForm.flag = name
            this.repairForm.lastTime = row.lastTime
            if(this.dialog_A.title == '发动机载体维修'){
                this.repairForm.url_A = row.url
            }
            this.dialog_A.show = true
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
            this.dialog.title='新增车辆信息',
            this.dialog.show = true
        },
        edit(row){
            
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
                this.$http.http_get(this,this.$api.car.remove.replace(/{serial}/,row.serial),null,true,(res)=>{
                    if(res.code == 1){
                        this.loadSearch()
                    }
                })
            }).catch(() => {
                      
            });
        },

        //查看
        look(row){
            this.$router.push({path:'/engine',query:{item:row}})
        },

        //提交表单
        publish(){
            this.$refs["publishForm"].validate(valid => {
				if (valid) {
					this.$http.http_post(this,this.$api.car.publish,this.publishForm,true,(res)=>{
                        if(res.code == 1){
                            this.loadSearch()
                            this.dialog.show = false
                        }
                    })			
				}
			});
        },

        //提交维修信息
        publishRepair(){
            this.$http.http_post(this,this.$api.car.repair,this.repairForm,true,(res)=>{
                if(res.code == 1){
                    this.loadSearch()
                    this.dialog_A.show = false
                }
            })
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
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>