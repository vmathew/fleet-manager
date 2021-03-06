package egen.io.navigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"egen.io.navigator"})
public class NavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavigatorApplication.class, args);
	}


}
