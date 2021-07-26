package net.kubepia.sam.restapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "net.kubepia.sam.restapp.mybatis")
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "This is petshop home";
	}

	// For tomcat access log
	// @Bean
	// public TomcatServletWebServerFactory servletContainer() {
	// TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	// tomcat.addContextValves(new LogbackValve());
	// return tomcat;
	// }

}
