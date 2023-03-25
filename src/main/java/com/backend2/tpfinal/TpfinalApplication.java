package com.backend2.tpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.backend2.tpfinal.seguridad", "com.backend2.tpfinal.Controller", "com.backend2.tpfinal.Service", "com.backend2.tpfinal.DTO"})
public class TpfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpfinalApplication.class, args);
    }

}
