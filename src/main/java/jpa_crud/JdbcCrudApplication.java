package jpa_crud;

import jpa_crud.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JdbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
		System.out.println("Programs runs successfully.");
	}

}
