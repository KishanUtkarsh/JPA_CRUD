package jpa_crud;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JdbcCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Programs runs successfully.");
	}
}
