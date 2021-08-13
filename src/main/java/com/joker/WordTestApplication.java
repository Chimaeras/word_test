package com.joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Joker
 */
@SpringBootApplication
@EnableAsync
public class WordTestApplication {

    public static void main ( String[] args ) {
        SpringApplication.run( WordTestApplication.class, args );
    }

}
