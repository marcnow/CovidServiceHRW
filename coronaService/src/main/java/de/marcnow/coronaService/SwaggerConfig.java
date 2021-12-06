package de.marcnow.coronaService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This a class to create a description of our interfaces with swagger
 * @version 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
   
	/**
    * This method creates the swagger page
    * @return Docket
    */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()
          .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))                                                        
          .build();                                           
    }
    
    /**
     * This method describes the api info
     * @return api info
     */
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("Corona Service API").description("Das System bereitet die Daten der John Hopkins Universität und des Robert Koch Instituts auf und berechnet Kennzahlen in Bezug zu Corona Situation in Deutschland. "
    			+ "Die Daten werden sowohl über eine SOAP, als auch eine REST Schnittstelle, "
    			+ "im JSON Format dem Telegram Bot HRWGruppe6_Herbert zur Verfügung gestellt.")
    			.version("V1.0").build();
    }
}