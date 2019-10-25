package com.bcopstein.interfaces.WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bcopstein"})
public class GarOOPaWS {
    public static void main(String args[]){
        SpringApplication.run(GarOOPaWS.class,args);
    }
}