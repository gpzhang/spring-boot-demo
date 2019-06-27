package com.example.demo.service;

import com.example.demo.model.BusinessModel;
import com.example.demo.param.RequestParam;
import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2018/7/12
 */
@Component
public class CommonSource {

    public CommonSource() {
        System.out.println("init CommonSource,thread:[" + Thread.currentThread().getName() + "],object:[" + this + "]");
        //扩展类加载器Main
        ClassLoader classLoader = CommonSource.class.getClassLoader();

        /**
         * 此处类加载器应该为WebappClassLoader
         */
        System.out.println("02 CommonSource类加载器:" + classLoader);

    }

    public BusinessModel getModel(RequestParam requestParam) {
        if (requestParam.getSource() == 0) {
            BusinessModel businessModel = new BusinessModel();
            businessModel.setDesc("通用model");
            businessModel.setType(0);
            return businessModel;
        }
        return null;
    }
}
