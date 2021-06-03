package net.kubepia.sam.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.access.tomcat.LogbackValve;

@SpringBootApplication
@RestController
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "This is petshop home";
	}

	@Bean
	public TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addContextValves(new LogbackValve());
		return tomcat;
	}

}
