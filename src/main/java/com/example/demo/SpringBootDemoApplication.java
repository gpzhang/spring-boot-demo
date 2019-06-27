package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author haishen
 * @date 2019-04-08
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        System.out.println("init SpringBootDemoApplication,thread:[" + Thread.currentThread().getName() + "]");
        //扩展类加载器Main
        ClassLoader classLoader = SpringBootDemoApplication.class.getClassLoader();

        /**
         * 此处类加载器应该为appClassLoader
         */
        System.out.println("00 SpringBootDemoApplication类加载器:" + classLoader);
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
