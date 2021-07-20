package com.itbear.impression;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ImpressionApplication {

    private static int PORT;

    @Value("${server.port}")
    public void setPort(int port) {
        PORT = port;
    }

    public static void main(String[] args) {
        ImpressionApplication app = new ImpressionApplication();
        SpringApplication.run(ImpressionApplication.class, args);
        System.out.println("http://localhost:"+ PORT + "/index");
    }

}
