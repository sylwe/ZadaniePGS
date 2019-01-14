package com.swlodyga.ZadaniePGS;

import com.swlodyga.ZadaniePGS.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({"com.swlodyga.ZadaniePGS","controller"})
@Import({SecurityConfig.class})
public class ZadaniePgsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadaniePgsApplication.class, args);
	}

}

