package jp.co.humane.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot起動クラス。
 * @author terada
 *
 */
@EnableAutoConfiguration
@ComponentScan("jp.co.humane.sample")
public class Main {

    /**
     * Spring Bootを起動する。
     * @param args 起動引数。
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
