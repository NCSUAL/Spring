package hello.SpringMVC_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //서블릿을 자동으로 등록해줌
@SpringBootApplication
public class SpringMvcServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcServletApplication.class, args);
	}

}
