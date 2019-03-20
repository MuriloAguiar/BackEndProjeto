package com.stefanini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}


/* 

{
    "id": 1,
    "nome": "Oculos 1",
    "situacao": "A",
    "lentes": [
        {
            "id": 1,
            "nome": "Lente 1"
        },
        {
            "id": 2,
            "nome": "Lente 2"
        }
    ]
}

*/