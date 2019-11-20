package com.hxq.configclient;

import com.hxq.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonServiceController {
    @Autowired // 自动注入PersonService
    private PersonService personService;

    @GetMapping("get/name")
    public String getPersonName(){
        return personService.getPersonName();// 调用PersonService服务的方法
    }

    @GetMapping("get/sex")
    public String getPersonSex(){
        return personService.getPersonSex();
    }
}
