package com.web.pcdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;

import org.springframework.web.bind.annotation.*;

import java.io.*;


import org.springframework.util.ResourceUtils;


import java.util.Properties;


@RestController
@SpringBootApplication
@ServletComponentScan
public class PcdpApplication {

    public static String ROOT = "c:/";

    public static void main(String[] args) {
        init();
        SpringApplication.run(PcdpApplication.class, args);
    }

    /**
     * 新增通过配置文件读取根目录
     */
    public static void init() {
        try {

            Properties props = new Properties();
            props.load(new FileInputStream(ResourceUtils.getFile("classpath:application.properties")));
            ROOT = props.getProperty("ROOT", ROOT);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
