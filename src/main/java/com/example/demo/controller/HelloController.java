package com.example.demo.controller;


import com.example.demo.param.RequestParam;
import com.example.demo.service.CommonSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haishen
 * @date 2018/7/12
 */
@RestController
public class HelloController {

    @Autowired
    private CommonSource commonSource;

    /**
     * 通过spring boot部署时,bean的加载初始化是通过线程
     * 来完成的
     */
    public HelloController() {
        System.out.println("init HelloController,thread:[" + Thread.currentThread().getName() + "],object:[" + this + "]");
        //扩展类加载器Main
        ClassLoader classLoader = HelloController.class.getClassLoader();

        /**
         * 此处类加载器应该为appClassLoader
         */
        System.out.println("01 HelloController类加载器:" + classLoader);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {

        RequestParam requestParam = new RequestParam();
        requestParam.setPlatform(110);
        requestParam.setSource(0);
        System.out.println(commonSource.getModel(requestParam).getDesc());
        return "ok!!!";
    }
}
