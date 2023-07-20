package studentManagement.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"studentManagement"})
public class StudentConfig {
 @Bean
  public EntityManager getEntityManager()
  {
	  return Persistence.createEntityManagerFactory("uday").createEntityManager();
  }
}
