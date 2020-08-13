package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Fixlog;
import com.gloryh.service.FixLogService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/infoadmin/fixlog")
public class FixLogHandler {

  @Autowired private FixLogService fixLogService;

  @RequestMapping("/fixingLogList")
  @GetMapping("/fixlog")
  @ResponseBody
  public String fixingLogList() {
    List<Fixlog> fixlogs = fixLogService.findFixingLogList();
    Gson gson = new Gson();
    return gson.toJson(fixlogs);
  }

  @RequestMapping("/fixingLogToFixedLog")
  @GetMapping("/fixlog")
  @ResponseBody
  public String fixingLogToFixedLog(@RequestBody Fixlog fixlog){
    System.out.println(fixlog.toString());
    int result = fixLogService.fixingLogToFixedLog(fixlog);
      return String.valueOf(result);
  }

  @RequestMapping("/fixedLogList")
  @GetMapping("/fixlog")
  @ResponseBody
  public String fixedLogList(){
    List<Fixlog> fixlogs =fixLogService.findFixedLogList();
    System.out.println(fixlogs.toString());
    Gson gson = new Gson();
    return gson.toJson(fixlogs);
  }
}
