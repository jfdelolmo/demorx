package com.example.jfo.demorx;

import com.example.jfo.demorx.initial.FlowConcurrence;
import com.example.jfo.demorx.initial.InitialDemos;
import com.example.jfo.demorx.initial.SimpleBackgroundComputation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRxApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoRxApplication.class, args);
//        InitialDemos.run();
//        SimpleBackgroundComputation.run();
        FlowConcurrence.run();
    }

}
