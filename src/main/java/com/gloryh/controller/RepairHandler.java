package com.gloryh.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Complaint;
import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Page;
import com.gloryh.entity.User;
import com.gloryh.service.RepairService;
import com.gloryh.service.WorkerService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.$Gson$Preconditions;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** @author admin */
@Controller
@RequestMapping("/waiter/repair")
public class RepairHandler {

  @Autowired private RepairService repairService;
  @Autowired private WorkerService workerService;
  @RequestMapping("/add")
  @GetMapping("/repair")
  @ResponseBody
  public String repairAddResult(@RequestBody Complaint complaint) {
    System.out.println(complaint.toString());
    complaint.setState(0);
    complaint.setType(0);
    //插入成功，获取id
    repairService.addRepair(complaint);
    String JsonObject;
    if(complaint.getId()!=0){
      JsonObject="{\"status\":0}";
    }else{
      JsonObject="{\"status\":1}";
    }
    Gson gson = new Gson();
    return gson.toJson(JsonObject) ;
  }

  @RequestMapping("/list")
  @GetMapping("/repair")
  @ResponseBody
  public String repairList(@RequestBody Integer thisPage) {
    int current;
    if (thisPage ==0){
      current =1;
    }else {
      current= thisPage;
    }
    Page page=repairService.repairList(current);
    Gson gson = new Gson();
    String JsonObject=gson.toJson(page);
    System.out.println(JsonObject);
    return JsonObject ;
  }

  @RequestMapping("/check")
  @GetMapping("/repair")
  @ResponseBody
  public JsonObject repairCheck(@RequestBody Integer id){
    Complaint repair=repairService.findRepairById(id);
    List<Map<String,Object>> list=workerService.findFreeWorker();
    Gson gson = new Gson();
    JsonObject jsonObject =new JsonObject();
    jsonObject.add("repair", gson.toJsonTree(repair));
    jsonObject.add("list", gson.toJsonTree(list));
    return jsonObject;
  }


  @RequestMapping("/dispatchWorkerAndRepairing")
  @GetMapping("/repair")
  @ResponseBody
  public String dispatchWorkerAndRepairing(@RequestBody String dispatchJson){
    System.out.println(dispatchJson);
    /**
     *  jackson.jar包可以将String转换为JsonObject
     */
    JSONObject jsonObject =JSONObject.parseObject(dispatchJson);
    String workerUsername=(String)jsonObject.get("workerUsername");
    User worker=workerService.findWorker(workerUsername);
    Fixlog fixlog = new Fixlog();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // 设置日期格式
    System.out.println("现在时间："+new Date());
    // new Date()为获取当前系统时间

    //日志第一次建立，读取到需要的参数字段后存入数据库
    fixlog.setBorrowtime(new Date());
    fixlog.setUsername(worker.getUsername());
    fixlog.setWorkername(worker.getName());
    fixlog.setReason((String)jsonObject.get("reason"));
    fixlog.setCustomername((String)jsonObject.get("customername"));
    fixlog.setToolname("无");
    fixlog.setToolcount(0);
    fixlog.setPartsname("无");
    fixlog.setPartscount(0);
    fixlog.setCustomerphone((String)jsonObject.get("phone"));
    fixlog.setCustomeraddress((String)jsonObject.get("address"));
    fixlog.setProductname((String)jsonObject.get("productname"));
    fixlog.setState(2);

    //1.存入数据库fixlog表
    repairService.creatFixLog(fixlog);
    String status;
    if(fixlog.getId()!=0){
      status="{\"status\":1}";
      //2.更新工人目前工作状态
      worker.setState(1);
      workerService.updateWorkerState(worker);
      //3.更新报修表维修状态为维修中
      int repairState=3;
      repairService.updateRepairState((String)jsonObject.get("repairId"),repairState);

    }else{
      status="{\"status\":2}";
    }

      return status;
  }
}
