package com.baiyu.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BPMApplication {
    public static void main(String[] args){
        SpringApplication.run(BPMApplication.class);
        System.out.println("bpm启动完成端口：8001");
    }
}
