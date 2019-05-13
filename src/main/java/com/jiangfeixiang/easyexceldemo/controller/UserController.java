package com.jiangfeixiang.easyexceldemo.controller;

import com.alibaba.excel.metadata.BaseRowModel;
import com.jiangfeixiang.easyexceldemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: easyexceldemo
 * @Package: com.jiangfeixiang.easyexceldemo.controller
 * @ClassName: UserController
 * @Author: jiangfeixiang
 * @email: 1016767658@qq.com
 * @Description: user
 * @Date: 2019/5/13/0013 15:37
 */
@Controller
public class UserController {


    @RequestMapping("/a")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
       for (int i=0;i<100;i++){
           User user = User.builder().name("张三"+ i).password("1234").age(i).build();
           userList.add(user);
       }
        return userList;
    }
}
