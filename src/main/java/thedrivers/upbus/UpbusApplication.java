package thedrivers.upbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class UpbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpbusApplication.class, args);
	}

}
