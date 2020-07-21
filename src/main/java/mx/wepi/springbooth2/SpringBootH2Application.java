package mx.wepi.springbooth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mangofactory.swagger.plugin.EnableSwagger;

@SpringBootApplication
@EnableSwagger
public class SpringBootH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2Application.class, args);
	}
}
