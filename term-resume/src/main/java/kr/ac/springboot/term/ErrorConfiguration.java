package kr.ac.springboot.term;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfiguration {
 
  @Bean
  public ConfigurableServletWebServerFactory containerCustomizer() {
	  TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
      factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/errors/404.html"));
      factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/errors/500.html"));
      return factory;	  
  }
}
