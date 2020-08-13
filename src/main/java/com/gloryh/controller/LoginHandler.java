package com.gloryh.controller;

import com.gloryh.entity.User;
import com.gloryh.service.LoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 *@author  hgh
 */

@Controller
@RequestMapping("/user")
public class LoginHandler {
  @Autowired private LoginService loginService;

  @RequestMapping(value = "/login")
  @GetMapping("/login")
  @ResponseBody
  public String login(@RequestBody User user) {
    System.out.println(user);
    Gson gson = new Gson();
    String jsonObject = "";
    // 查询是否存在该用户信息。
    int count = loginService.countUser(user.getUsername(), user.getRole());
    if (count == 0) {
      jsonObject = "{\"status\":1}";
      // String转json格式："{\"pids\":[\"1\",\"2\",\"3\"]}"
    } else {
      User result = loginService.findUser(user.getUsername(), user.getRole());
      System.out.println(result.toString() + "----------------");
      if (result.getPassword().equals(user.getPassword())) {
        jsonObject = "{\"status\":0" + ",\"name\":" + "\"" + result.getName() + "\"" + "}";

      } else {
        jsonObject = "{\"status\":2}";
      }
    }
    String json = gson.toJson(jsonObject);
    System.out.println(json);
    return json;
  }
}
