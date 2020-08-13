package com.gloryh.controller;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Page;
import com.gloryh.service.ComplaintService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/waiter/complaint")
public class ComplaintHandler {
  @Autowired private ComplaintService complaintService;

  @RequestMapping("/add")
  @GetMapping("/waiter")
  @ResponseBody
  public String complaintAddResult(@RequestBody Complaint complaint) {
    System.out.println(complaint.toString());
    complaint.setState(0);
    complaint.setType(1);
    //插入成功，获取id
    complaintService.addComplaint(complaint);
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
  @GetMapping("/complaint")
  @ResponseBody
  public String complaintList(@RequestBody Integer thisPage) {
    int current=thisPage;
    if (thisPage == 0) {
      current = 1;
    }
    Page page = complaintService.complaintList(current);
    Gson gson = new Gson();
    String JsonObject = gson.toJson(page);
    System.out.println(JsonObject);
    return JsonObject;
  }

  @RequestMapping("/check")
  @GetMapping("/complaint")
  @ResponseBody
  public String repairCheck(@RequestBody Integer id){
    Complaint repair=complaintService.findComplaintById(id);
    Gson gson = new Gson();
    String jsonObject = gson.toJson(repair);
    return jsonObject;
  }

  @RequestMapping("/solveComplaint")
  @GetMapping("/complaint")
  @ResponseBody
  public String solveComplaint(@RequestBody Integer id){
    int ans =complaintService.solveComplaint(id);
    System.out.println("result:"+ans);
    Gson gson = new Gson();
    String jsonObject;
    if (ans==1){
      jsonObject="{\"status\":1}";
    }else{
      jsonObject="{\"status\":0}";
    }
    return gson.toJson(jsonObject);
  }
}
