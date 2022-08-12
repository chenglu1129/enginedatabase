package com.nytd.retail.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nytd.retail.entity.FrontRudder;
import com.nytd.retail.entity.UserAccount;
import com.nytd.retail.mapper.*;
import com.nytd.retail.service.CarService;
import com.nytd.retail.service.FileModuleService;
import com.nytd.retail.service.RepairRecordService;
import com.nytd.retail.service.UserAccountService;
import com.nytd.retail.util.Result;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Component
public class BaseController {

    @Resource
    protected UserAccountService userAccountService;


    @Resource
    protected FileModuleService fileModuleService;

    @Resource
    protected CarService carService;

    @Resource
    protected EngineCarrierMapper engineCarrierMapper;

    @Resource
    protected BackSkirtMapper backSkirtMapper;

    @Resource
    protected FrontRudderMapper frontRudderMapper;

    @Resource
    protected LeftRearWheelMapper leftRearWheelMapper;

    @Resource
    protected LeftFrontWheelMapper leftFrontWheelMapper;

    @Resource
    protected RearRudderMapper rearRudderMapper;

    @Resource
    protected RightFrontWheelMapper rightFrontWheelMapper;

    @Resource
    protected RightRearWheelMapper rightRearWheelMapper;

    @Resource
    protected SilkSleeveMapper silkSleeveMapper;

    @Resource
    protected RepairRecordService repairRecordService;


    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public HttpServletRequest getRequest() {

        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    //响应流
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }






    /**
     * 返回当前用户账户对象
     * @param checker
     * @return
     */
    public UserAccount getUserAccount(Result checker){
        JSONObject json = (JSONObject) JSON.toJSON(checker.getData());
        UserAccount userAccount = JSON.parseObject(json.toJSONString(), UserAccount.class);
        return userAccount;
    }


}
