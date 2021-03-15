package com.hanjie.opt;

import com.hanjie.opt.example.opt.CommonOptStatusPolicy;
import kim.hanjie.common.opt.IOptStatusPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author han
 * @date 2021/3/11
 */
@SpringBootApplication
public class OptExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(OptExampleApplication.class, args);
    }

    @Bean
    public IOptStatusPolicy optStatusPolicy() {
        return new CommonOptStatusPolicy();
    }
}
