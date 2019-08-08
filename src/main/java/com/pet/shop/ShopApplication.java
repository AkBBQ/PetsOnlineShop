package com.pet.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@MapperScan("com.pet.shop.mapper")
@SpringBootApplication
public class ShopApplication {
    private final static Logger logger = LoggerFactory.getLogger(ShopApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(ShopApplication.class, args);
        Environment env = application.getEnvironment();
        System.out.println("里面有什么鬼东西"+env);
        System.out.println("端口号"+env.getProperty("server.ports"));
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:8088\n\t" +
                        "swagger: \t\thttp://localhost:8088/swagger-ui.html\n\t"+
                        "Doc: \thttp://{}:{}/api/swagger-ui.html\n"+
                        "----------------------------------------------------------",
               env.getProperty("spring.application.name"));
    }
}
