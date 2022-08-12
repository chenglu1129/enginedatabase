package com.nytd.retail.controller;

import com.nytd.retail.base.BaseController;
import com.nytd.retail.base.BaseMessage;
import com.nytd.retail.util.DataUtil;
import com.nytd.retail.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className CommonController
 * @projectName mall_user
 * @date 2022/4/20
 */

@RestController
@RequestMapping("/v1/api/commen")
public class CommonController extends BaseController {

    static final String path = "C:\\Users\\92872\\Desktop\\engine\\files\\";
    static final String url = "http://127.0.0.1:8051/files/engine/";


//    static final String path = "/root/server/files/";
//    static final String url = "http://82.156.208.40:9000/gateway/mall/files/";
    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result uploadFile(@RequestPart("file") MultipartFile file){

        try{

            if (file != null) {

                String fileName = file.getOriginalFilename();
                fileName = fileName.replaceAll("\\+","");
                fileName = fileName.replaceAll("-","");
                fileName = fileName.trim();
                fileName = DataUtil.getPreFileForDate("")+fileName;

                File destFile = new File(path+fileName);

                if (destFile.exists()){
                    file.transferTo(destFile);
                }else {
                    new File(path).mkdir();
                    file.transferTo(destFile);
                }

                Map<String,Object> fileInfo = new HashMap<>();

                fileInfo.put("name",fileName);
                fileInfo.put("url",url+fileName);

                return Result.success("文件上传成功", Arrays.asList(fileInfo));

            }

            return Result.error("文件上传失败，请通知管理员");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.toString());
    }
}
