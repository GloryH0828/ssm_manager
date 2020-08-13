package com.gloryh.controller;

import com.gloryh.entity.Consult;
import com.gloryh.entity.Page;
import com.gloryh.service.ConsultService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/waiter/consult")
public class ConsultHandler {

  @Autowired private ConsultService consultService;

  @RequestMapping("/add")
  @GetMapping("/consult")
  @ResponseBody
  public String consultAddResult(@RequestBody Consult consult) {
    System.out.println(consult.toString());
    System.out.println("插入前consult的id值为：" + consult.getId());
    consultService.addConsult(consult);
    System.out.println("插入后consult的id值为：" + consult.getId());
    String JsonObject;
    if (consult.getId() != 0) {
      JsonObject = "{\"status\":0}";
    } else {
      JsonObject = "{\"status\":1}";
    }
    Gson gson = new Gson();
    return gson.toJson(JsonObject);
  }

  @RequestMapping("/list")
  @GetMapping("/consult")
  @ResponseBody
  public String consultList(@RequestBody Integer thisPage) {
    int current;
    if (thisPage == 0) {
      current = 1;
    } else {
      current = thisPage;
    }
    Page page = consultService.repairList(current);
    Gson gson = new Gson();
    String JsonObject = gson.toJson(page);
    System.out.println(JsonObject);
    return JsonObject;
  }
}
