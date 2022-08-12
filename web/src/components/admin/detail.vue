<!-- eslint-disable -->
<template>
    <div id="detail">
        <dv-full-screen-container>
            <div id="top">
                <dv-decoration-8  class="header-left-decoration"/>
                <dv-decoration-5 class="header-center-decoration" />
                <dv-decoration-8 class="header-right-decoration" :reverse="true" />
                <div class="center-title">发动机载体维保信息查询系统</div>
            </div> 
            <div id="content">
                <div id="_left">
                    <dv-border-box-8 style="width:95%">
                        <div class="inner_title">
                            <dv-decoration-9 id="top_dec">查看各部位维修情况</dv-decoration-9>
                        </div>
                        
                        <div class="inner_">
                            <div style="margin-bottom:20px">
                                <el-tag  effect='dark' class="one" @click="search(car.serial,car.frontRudder.serial)">前舵</el-tag>
                                <el-tag  effect='dark' class="one" @click="search(car.serial,car.leftFrontWheel.serial)">左前轮</el-tag>
                                <el-tag  effect='dark' class="one" @click="search(car.serial,car.leftRearWheel.serial)">左后轮</el-tag>
                                <el-tag  effect='dark' class="one" @click="search(car.serial,car.rightFrontWheel.serial)">右前轮</el-tag>
                            </div>
                            <div >
                                <el-tag  effect='dark' class="two" @click="search(car.serial,car.rightRearWheel.serial)">右后轮</el-tag>
                                <el-tag  effect='dark' class="two" @click="search(car.serial,car.backSkirt.serial)">护裙</el-tag>
                                <el-tag  effect='dark' class="two" @click="search(car.serial,car.silkSleeve.serial)">丝套</el-tag>
                            </div>
                        </div>
                    </dv-border-box-8>
                    
                </div>
                <div id="center">
                    <div class="title" >
                        <dv-decoration-3 style="width:250px;height:60px;" />
                        <div style="padding-top:8px">
                            <el-tag style='margin-right:8px' effect='dark' type='success' size='mini' v-for="(item,index) in cars" :key="index" @click="searchByCar(item)">载体{{index+1}}</el-tag>
                        </div>
                        <dv-decoration-3 style="width:250px;height:60px;margin-right:30px" />
                        <div @click="home">
                            <dv-decoration-11 style="width:150px;height:43px;margin-top:10px">返回主页</dv-decoration-11>
                        </div>
                            
                    </div>
                    
                    <dv-border-box-10 style="width:95%;">
                        <div id="myEcharts" style="width:100%;height:450px"></div>
                    </dv-border-box-10>
                </div>
            </div>
           
                
        </dv-full-screen-container>
    </div>
</template>

<script>
/* eslint-disable */ 
import * as echarts from 'echarts';
export default {
    data () {
        return {
            car:{},
            colors:['#37a2da','#32c5e9','#67e0e3','#9fe6b8','#ffdb5c','#ff9f7f','#fb7293','#e062ae','#96bfff'],
            option :{
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data: [],
                    textStyle: {
                        color: "#FFFFFF"
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },              
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    //data: [ '1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    data:[
                        {value:'1月',textStyle:{color:'#FFFFFF'}},
                        {value:'2月',textStyle:{color:'#FFFFFF'}},
                        {value:'3月',textStyle:{color:'#FFFFFF'}},
                        {value:'4月',textStyle:{color:'#FFFFFF'}},
                        {value:'5月',textStyle:{color:'#FFFFFF'}},
                        {value:'6月',textStyle:{color:'#FFFFFF'}},
                        {value:'7月',textStyle:{color:'#FFFFFF'}},
                        {value:'8月',textStyle:{color:'#FFFFFF'}},
                        {value:'9月',textStyle:{color:'#FFFFFF'}},
                        {value:'10月',textStyle:{color:'#FFFFFF'}},
                        {value:'11月',textStyle:{color:'#FFFFFF'}},
                        {value:'12月',textStyle:{color:'#FFFFFF'}}
                    ]
                },
                yAxis: {
                    type: 'value',
                    min: 0,
                    max: 20,
                    interval: 1,
                    splitLine: {
                        lineStyle: {
                            color: '#fff',
                            opacity:0.3
                        }
                    },
                },
                series: []
            },
            cars:[]
            
        }
    },

    methods:{
        
        //返回主页
        home(){
            this.$router.push({path:'/admin'})
        },
        //点击载体
        searchByCar(car){
            this.car = car
            let searchForm = {'carSerial':car.serial}
            this.$http.http_post(this,this.$api.car.detail,searchForm,false,(res)=>{
                if(res.code == 1){
                    this.option.legend.data = []
                    this.option.series = []
                    for (var key in res.data){
                        this.option.legend.data.push(key)
                        let datas = [0,0,0,0,0,0,0,0,0,0,0,0]
                        let arr = res.data[key]
                        this.option.xAxis.data.filter((item,index) =>{
                            let mon = (item.value.split(''))[0]
                            arr.filter(item_A => {
                                if(item_A.mon == mon){
                                    datas[index] = item_A.count
                                }
                            })
                        })
                        
                        let obj = {

                            emphasis: {
                                focus: 'series'
                            },
                            smooth: true,
                            name: key,
                            type: 'line',
                            stack: 'Total',
                            stackStrategy:'all',
                            data: datas,
                            lineStyle:{
                                color:'#fff'
                            }
                        }
                        this.option.series.push(obj)
                    }

                    //改折线颜色
                    this.option.series.filter((item,index) => {
                        this.colors.filter((item_A,index_A) => {
                            if(index == index_A){
                                item.lineStyle.color = item_A
                            }
                        })
                    })
                    this.echartsInit()
                }else{
                    this.$message.error('暂未查询到维修信息')
                }
            })
        },
        //点击查询折线图
        search(carSerial,bs){
            let searchForm = {'carSerial':carSerial,'moduleSerial':bs}
            this.$http.http_post(this,this.$api.car.detail,searchForm,false,(res)=>{
                if(res.code == 1){
                    this.option.legend.data = []
                    this.option.series = []
                    for (var key in res.data){
                        this.option.legend.data.push(key)
                        let datas = [0,0,0,0,0,0,0,0,0,0,0,0]
                        let arr = res.data[key]
                        this.option.xAxis.data.filter((item,index) =>{
                            let mon = (item.value.split(''))[0]
                            arr.filter(item_A => {
                                if(item_A.mon == mon){
                                    datas[index] = item_A.count
                                }
                            })
                        })
                        
                        let obj = {
                            emphasis: {
                                focus: 'series'
                            },
                            smooth: true,
                            name: key,
                            type: 'line',
                            stack: 'Total',
                            stackStrategy:'all',
                            data: datas,
                            lineStyle:{
                                color:'#fff'
                            }
                        }
                        this.option.series.push(obj)
                    }

                    //改折线颜色
                    this.option.series.filter((item,index) => {
                        this.colors.filter((item_A,index_A) => {
                            if(index == index_A){
                                item.lineStyle.color = item_A
                            }
                        })
                    })
                    this.echartsInit()
                }else{
                    this.$message.error('暂未查询到维修信息')
                }
            })
        },


        echartsInit() {
            //生成echarts
            var es = echarts.init(document.getElementById('myEcharts'))
            es.clear()
            es.setOption(this.option)
        },

        //加载查询折线图
        getEcharts(){
            let searchForm = {'carSerial':this.car.serial}
            this.$http.http_post(this,this.$api.car.detail,searchForm,false,(res)=>{
                if(res.code == 1){
                    for (var key in res.data){
                        this.option.legend.data.push(key)
                        let datas = [0,0,0,0,0,0,0,0,0,0,0,0]
                        let arr = res.data[key]
                        this.option.xAxis.data.filter((item,index) =>{
                            let mon = (item.value.split(''))[0]
                            arr.filter(item_A => {
                                if(item_A.mon == mon){
                                    datas[index] = item_A.count
                                }
                            })
                        })
                        
                        let obj = {

                            emphasis: {
                                focus: 'series'
                            },
                            smooth: true,
                            name: key,
                            type: 'line',
                            stack: 'Total',
                            stackStrategy:'all',
                            data: datas,
                            lineStyle:{
                                color:'#fff'
                            }
                        }
                        this.option.series.push(obj)
                    }

                    //改折线颜色
                    this.option.series.filter((item,index) => {
                        this.colors.filter((item_A,index_A) => {
                            if(index == index_A){
                                item.lineStyle.color = item_A
                            }
                        })
                    })
                    this.echartsInit()
                }else{
                    this.$message.error('暂未查询到维修信息')
                }
            })
        },

        //查所有载体
        getCars(){
            this.$http.http_get(this,this.$api.car.getCars,null,false,(res)=>{
                console.log('cars',res)
                if(res.code == 1){
                    this.cars = res.data
                }
            })
        }
    },

    mounted(){
        this.car = this.$route.query.car
        if(this.car!=null && this.car!=undefined){
            this.getEcharts()
            this.getCars()
        }
    },

    
}
</script>

<style scoped>
/* eslint-disable */ 

    #top{
        position: relative;
        width: 100%;
        height: 180px;
        margin-top: 10px;
        margin-bottom: 30px;
        display: flex;
        justify-content: space-between;
        flex-shrink: 0;
    }
     .header-center-decoration {
        width: 50%;
        height: 100px;
        margin-top: 31px;
    }

    .header-left-decoration{
        width: 25%;
        height: 100px;
    }

    .header-right-decoration{
        width: 25%;
        height: 100px;
       
    }

    .center-title {
        position: absolute;
        font-size: 20px;
        font-weight: bold;
        left: 50%;
        top: 40px;
        transform: translateX(-50%);
    }
    #top_dec{
        width:230px;
        height:220px;
        margin: 0 auto;
    }

    
    #detail{
        width: 100%;
        height: 100%;
        background-color: #030409;
        color: #fff;
    }
    #dv-full-screen-container {
        background-image: url('../../assets/bg.png');
        background-size: 100%;
        box-shadow: 0 0 3px blue;
        display: flex;
        flex-direction: column;
        height: 1300px;
        width: 2000px
    }
    #content{
        display: flex;
        width: 100%;
        height: 500px;
    }
    #_left{
        width: 30%;
        height: 530px;
        margin-right: 20px;
        margin-left: 20px;
    }
    #center{
        width: 68%;
        height: 450px;
        
    }
    
    .one {
        margin-right: 20px;
        color:white;
        background-color: #FF6633;
        border: none;
        font-weight: bold;
        cursor: pointer;
    }
    .two{
        margin-right: 20px;
        color:white;
        background-color: #FF6633;
        border: none;
        font-weight: bold;
        cursor: pointer;
    }
    .title{
        width: 920px;
        display: flex;
        margin-bottom: 20px;
    }
    .inner_title{
        width: 100%;
        height: 280px;
        font-weight: bold; 
        padding-top: 20px; 
    }
    .inner_{
        width: 80%;
        margin-left: 50px;
        
    }
</style>