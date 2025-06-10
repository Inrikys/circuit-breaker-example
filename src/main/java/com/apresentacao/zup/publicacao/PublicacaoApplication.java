package com.apresentacao.zup.publicacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PublicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicacaoApplication.class, args);
	}

}
