<!-- eslint-disable -->
<template>
    <div id="engines">
        <dv-full-screen-container>
            <div id="top">
                <dv-decoration-8  class="header-left-decoration"/>
                <dv-decoration-5 class="header-center-decoration" />
                <dv-decoration-8 class="header-right-decoration" :reverse="true" />
                <div class="center-title">发动机载体维保信息查询系统</div>
            </div> 

            <div id="content">
                <div class="topContent">
                    <div class="_left">
                        <div>
                            <dv-border-box-11 title="左前轮" style="height:200px" >
                                <div @click="info(car.serial)" class="info" ></div>
                                <div class="lfw" >
                                    <div v-if="car.leftFrontWheel.lastTime!=null">
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:-30px;margin-right:100px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.leftFrontWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.leftFrontWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                    <div v-else>
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:0px;margin-right:50px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.leftFrontWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.leftFrontWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                </div>
                            </dv-border-box-11>
                        </div>
                        <div>
                            <dv-border-box-11 title="右前轮" style="height:200px">
                                <div @click="info(car.serial)" class="info" ></div>
                                <div class="rfw">
                                    <div v-if="car.rightFrontWheel.lastTime!=null">
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:-30px;margin-right:100px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.rightFrontWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.rightFrontWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                    <div v-else>
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:0px;margin-right:50px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.rightFrontWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.rightFrontWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                </div>
                            </dv-border-box-11>
                        </div>
                    </div>
                    <div class="_center">
                        <dv-border-box-1>
                            <span style="font-size:20px;font-weight:bolder" @click="info(car.serial)">发动机载体</span>
                            <div class="ec">
                                <div >
                                    <div style="margin-top:35px">
                                        <el-tag type="danger" effect='dark' style="margin-left:-30px;margin-right:100px">维修次数</el-tag>
                                        <span style="font-size:14px">{{car.engineCarrier.count}}</span>
                                    </div>
                                    <div style="margin-top:10px">
                                        <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                        <span style="margin-left:20px;font-size:14px">{{car.engineCarrier.lastTime}}</span>
                                    </div>
                                </div>
                                <div style="margin-left:30px">
                                    <el-image :src='this.car.engineCarrier.url' fit='fill' style="width:300px;height:200px"></el-image>
                                </div>
                            </div>
                        </dv-border-box-1>
                    </div>
                    <div class="_right">
                        <div>
                            <dv-border-box-11 title="左后轮" style="height:200px">
                                <div @click="info(car.serial)" class="info" ></div>
                                <div class="lrw">
                                    <div v-if="car.leftRearWheel.lastTime!=null">
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:-30px;margin-right:100px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.leftRearWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.leftRearWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                    <div v-else>
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:0px;margin-right:50px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.leftRearWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.leftRearWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                </div>
                            </dv-border-box-11>
                        </div>
                        <div>
                            <dv-border-box-11 title="右后轮" style="height:200px">
                                <div @click="info(car.serial)" class="info" ></div>
                                <div class="rrw">
                                    <div v-if="car.rightRearWheel.lastTime!=null">
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:-30px;margin-right:100px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.rightRearWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.rightRearWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                    <div v-else>
                                        <div>
                                            <el-tag type="danger" effect='dark' style="margin-left:0px;margin-right:50px">维修次数</el-tag>
                                            <span style="font-size:14px">{{car.rightRearWheel.count}}</span>
                                        </div>
                                        <div style="margin-top:10px">
                                            <el-tag type="danger" effect='dark'>最近一次维修时间</el-tag>
                                            <span style="margin-left:20px;font-size:14px">{{car.rightRearWheel.lastTime}}</span>
                                        </div>
                                    </div>
                                </div>
                            </dv-border-box-11>
                        </div>
                    </div>
                </div>

                <div class="bottomContent">
                    
                    <div class="backSkirt" >
                        <dv-border-box-11 title="护裙" style="height:200px;width:330px;">
                            <div @click="info(car.serial)" class="info_A" ></div>
                            <div class="bk">
                                <div style="height:22%;width:200px">
                                    <el-tag type="danger" effect='dark' style="margin-left:-20px;">维修次数</el-tag>
                                    <span style="font-size:14px;margin-left:80px">{{car.backSkirt.count}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-if="car.backSkirt.lastTime == null">
                                    <el-tag type="danger" effect='dark' style="margin-left:-100px;margin-right:10px">最近一次维修时间</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.backSkirt.lastTime}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-else>
                                    <el-tag type="danger" effect='dark' style="margin-left:-10px;margin-right:10px">最近一次维修时间</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.backSkirt.lastTime}}</span>
                                </div>
                            </div>
                        </dv-border-box-11>
                    </div>
                    <div class="frontBudder">
                        <dv-border-box-11 title="前舵" style="height:200px;width:330px">
                            <div @click="info(car.serial)" class="info_A" ></div>
                             <div class="fb">
                                <div style="height:22%;width:200px">
                                    <el-tag type="danger" effect='dark' style="margin-left:-20px;">维修次数</el-tag>
                                    <span style="font-size:14px;margin-left:80px">{{car.frontRudder.count}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-if="car.frontRudder.lastTime == null">
                                    <el-tag type="danger" effect='dark' style="margin-left:-100px;margin-right:10px">最近一次维修时间</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.frontRudder.lastTime}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-else>
                                    <el-tag type="danger" effect='dark' style="margin-left:-10px;margin-right:10px">最近一次维修时间2</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.frontRudder.lastTime}}</span>
                                </div>
                            </div>
                        </dv-border-box-11>
                    </div>
                    <div class="rearBudder">
                        <dv-border-box-11 title="后舵" style="height:200px;width:330px">
                            <div @click="info(car.serial)" class="info_A" ></div>
                            <div class="rb">
                                <div style="height:22%;width:200px">
                                    <el-tag type="danger" effect='dark' style="margin-left:-20px;">维修次数</el-tag>
                                    <span style="font-size:14px;margin-left:80px">{{car.rearRudder.count}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-if="car.rearRudder.lastTime == null">
                                    <el-tag type="danger" effect='dark' style="margin-left:-100px;margin-right:10px">最近一次维修时间</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.rearRudder.lastTime}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-else>
                                    <el-tag type="danger" effect='dark' style="margin-left:-10px;margin-right:10px">最近一次维修时间2</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.rearRudder.lastTime}}</span>
                                </div>
                            </div>
                        </dv-border-box-11>
                    </div>
                    <div class="sleeveBudder">
                        <dv-border-box-11 title="丝套" style="height:200px;width:330px">
                            <div @click="info(car.serial)" class="info_A" ></div>
                            <div class="rb">
                                <div style="height:22%;width:200px">
                                    <el-tag type="danger" effect='dark' style="margin-left:-20px;">维修次数</el-tag>
                                    <span style="font-size:14px;margin-left:80px">{{car.silkSleeve.count}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-if="car.silkSleeve.lastTime == null">
                                    <el-tag type="danger" effect='dark' style="margin-left:-100px;margin-right:10px">最近一次维修时间</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.silkSleeve.lastTime}}</span>
                                </div>
                                <div style="margin-top:5px;width:240px;height:50px" v-else>
                                    <el-tag type="danger" effect='dark' style="margin-left:-10px;margin-right:10px">最近一次维修时间2</el-tag>
                                    <span style="margin-left:10px;font-size:14px">{{car.silkSleeve.lastTime}}</span>
                                </div>
                            </div>
                        </dv-border-box-11>
                    </div>
                </div>
            </div>
                
        </dv-full-screen-container>
        
    </div>
</template>

<script>

/* eslint-disable */
export default {
    data(){
        return{
            car:{}
        }
    },
    methods:{
        info(carSerial){
            this.$router.push({path:'/detail',query:{car:this.car}})
        }
    },
    created(){
        this.car = this.$route.query.item       
    },
    
    
}
</script>

<style scoped>
    #engines{
        width: 100%;
        height: 100%;
        background-color: #030409;
        color: #fff;
    }
    #top{
        position: relative;
        width: 100%;
        height: 120px;
        margin-top: 10px;
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
        font-size: 25px;
        font-weight: bold;
        left: 50%;
        top: 40px;
        transform: translateX(-50%);
    }

    #content{
        width: 100%;
        height: 600px;
    }

    .topContent{
        height: 65%;
        padding: 10px;
        display: flex
    }
    ._left{
        height: 100%;
        width: 25%;
        margin-right: 10px;
    }
    ._center{
        height: 100%;
        width: 50%;
        margin-right: 10px;
    }
    ._right{
        height: 100%;
        width: 25%;
    }
    .bottomContent{
        height: 40%;
        margin-top: 5px;
        display: flex;
    }

    .bottomContent div{
        width: 30%;
        height: 90%;
        margin: 5px 0 0 10px;
    }

    .lfw{
        position:absolute;
        top: 80px;
        left: 50px;
    }
    .rfw{
        position:absolute;
        top: 80px;
        left: 50px;
    }
    .lrw{
        position:absolute;
        top: 80px;
        left: 50px;
    }
    .rrw{
        position:absolute;
        top: 80px;
        left: 50px;
    }
    .ec{
        position:absolute;
        top: 80px;
        left: 50px;
        display: flex;
    }
    .bk{
        position:absolute;
        top: 60px;
        left: 25px;
    }
    .fb{
        position:absolute;
        top: 60px;
        left: 25px;
    }
    .rb{
        position:absolute;
        top: 60px;
        left: 25px;
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
    .info{
        height:50px;
        line-height: 50px;
        cursor: pointer;
    }

    .info_A {
        position: absolute;
        left: 100px;
        cursor: pointer;
    }
        
</style>