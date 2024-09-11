package com.aldoca.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


        String url = "https://catfact.ninja/fact?max_length=140";

        WebClient.Builder builder = WebClient.builder();

        String catFact = builder.build()
                .get().uri(url).retrieve().bodyToMono(String.class).block();

        System.out.println("---------------------------------");
        System.out.println(catFact);





	}

}
