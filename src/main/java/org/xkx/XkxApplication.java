package org.xkx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("对应的包，这是方法二")
public class XkxApplication {

    public static void main(String[] args) {
        SpringApplication.run(XkxApplication.class, args);
    }


}
