package co.edu.iudigital.app.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración de Swagger
 * @author Juan David
 *
 */
@Configurable
@EnableSwagger2

public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("co.edu.iudigital.app.controller"))
						.paths(PathSelectors.any())
						.build()
						.apiInfo(apiInfo());	
	}
	

	private ApiInfo apiInfo() {
		return new ApiInfo("API de HelpMe IU-Digital", "API para la App de HelpMeIUD", "1.0", 
							"https://iudigital.edu.co", new Contact("Adriana Aguilar",
																	"https://github.com/jadris7",
																	"adriana.aguilar@est.iudigital.edu.co"), 
						      "Apache 2.0",
						      "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
}
