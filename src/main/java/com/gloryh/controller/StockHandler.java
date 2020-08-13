package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Putin;
import com.gloryh.entity.Stock;
import com.gloryh.service.StockService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/stock")
public class StockHandler {
  @Autowired private StockService stockService;

  @RequestMapping("/findAll")
  @GetMapping("/stock")
  @ResponseBody
  public String findAll() {
    List<Stock> parts1 = stockService.findByType(1);
    List<Stock> tools1 = stockService.findByType(0);
    List<Stock> tools2 = stockService.findByQuantity(0, 5);
    List<Stock> parts2 = stockService.findByQuantity(1, 10);
    List<Stock> parts3 = stockService.findByType(2);
    List<Stock> tools3 = stockService.findByType(3);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("parts1", parts1);
    jsonObject.put("parts2", parts2);
    jsonObject.put("parts3", parts3);
    jsonObject.put("tools1", tools1);
    jsonObject.put("tools2", tools2);
    jsonObject.put("tools3", tools3);
    return jsonObject.toJSONString();
  }

  @RequestMapping("/loadWorker")
  @GetMapping("/stock")
  @ResponseBody
  public String loadWorker() {
    List<Fixlog> fixlogs = stockService.loadWorker();
    Gson gson = new Gson();
    return gson.toJson(fixlogs);
  }

  @RequestMapping("/findFixLogInfoByID")
  @GetMapping("/stock")
  @ResponseBody
  public String findFixLogInfoByID(@RequestBody Integer id) {
    System.out.println("id:" + id);
    List<Fixlog> fixlog = stockService.findFixLogInfoByID(id);
    List<Stock> parts = stockService.findByType(1);
    List<Stock> tools = stockService.findByType(0);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("fixlog",fixlog);
    jsonObject.put("parts", parts);
    jsonObject.put("tools",tools);
    System.out.println(jsonObject.toJSONString());
    return jsonObject.toJSONString();
  }

  @RequestMapping("/outOfStorage")
  @GetMapping("/stock")
  @ResponseBody
  public String outOfStorage(@RequestBody String outInfo){
    JSONObject jsonObject = JSONObject.parseObject(outInfo);

    /*System.out.println(jsonObject.toJSONString());*/

    Fixlog fixlog =new Fixlog();
    fixlog.setId(Integer.valueOf((String)jsonObject.get("id")));
    fixlog.setPartscount(Integer.valueOf((String)jsonObject.get("partsCount")));
    fixlog.setPartsname((String)jsonObject.get("partsName"));
    fixlog.setToolname((String)jsonObject.get("toolsName"));
    fixlog.setToolcount(1);

    /*System.out.println(fixlog.toString());*/

    stockService.outOfStorage(fixlog);
    return "";
  }

  @RequestMapping("/findBorrowed")
  @GetMapping("/stock")
  @ResponseBody
  public String findBorrowed(){
    List<Fixlog> fixlogs =stockService.findBorrowed();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("fixlogs", fixlogs);
    return jsonObject.toJSONString();
  }

  @RequestMapping("/itemStorage")
  @GetMapping("/stock")
  @ResponseBody
  public String itemStorage(@RequestBody Putin putin){
    System.out.println(putin.toString());
    stockService.itemStorage(putin);
    return "";
  }

  @RequestMapping("/findFixLogByID")
  @GetMapping("/stock")
  @ResponseBody
  public String findFixLogByID(@RequestBody Integer fixLogId){
    System.out.println("id:"+fixLogId);
    List<Fixlog> fixlog = stockService.findFixLogInfoByID(fixLogId);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("fixlog", fixlog);
    return jsonObject.toJSONString();
  }

  @RequestMapping("/itemReturn")
  @GetMapping("/stock")
  @ResponseBody
  public String itemReturn(@RequestBody String itemReturnInfo){
    JSONObject jsonObject = JSONObject.parseObject(itemReturnInfo);
    System.out.println(jsonObject.toJSONString());
    Integer newCount =Integer.valueOf((String)jsonObject.get("newCount"));
    Integer oldCount =Integer.valueOf((String)jsonObject.get("oldCount"));
    Integer fixLogId =Integer.valueOf((String)jsonObject.get("id"));
    String toolName =(String)jsonObject.get("toolName");
    String opName =(String)jsonObject.get("partsname");
    stockService.itemReturn(newCount, oldCount, fixLogId, opName, toolName);
    return "";
  }
}
