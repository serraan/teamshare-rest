package it.linksmt.teamshare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis( RequestHandlerSelectors.any() )
					.paths( PathSelectors.any() )
					.build()
				.apiInfo( apiInfo() )
				.useDefaultResponseMessages(false)
					.globalResponseMessage(RequestMethod.GET, errorList())
					.globalResponseMessage(RequestMethod.POST, errorList())
					.globalResponseMessage(RequestMethod.PUT, errorList())
					.globalResponseMessage(RequestMethod.DELETE, errorList());
		// @formatter:on
	}

	private List<ResponseMessage> errorList() {
		// @formatter:off
		List<ResponseMessage> lista = new ArrayList<ResponseMessage>();
		lista.add( new ResponseMessageBuilder()   
				.code(500)
				.message("500 message")
				.responseModel(new ModelRef("ErrorRestService"))
				.build());
		lista.add( new ResponseMessageBuilder()   
				.code(400)
				.message("Bad Request")
				.responseModel(new ModelRef("ErrorRestService"))
				.build());
		lista.add( new ResponseMessageBuilder()   
				.code(401)
				.message("Non Autorizzato")
				.responseModel(new ModelRef("ErrorRestService"))
				.build());
		lista.add( new ResponseMessageBuilder()   
				.code(412)
				.message("Errore Validazione")
				.responseModel(new ModelRef("ErrorRestService"))
				.build());
		return lista;
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		// @formatter:off
		return new ApiInfoBuilder()
			.title( "Team Share API" )
			.description( "RESTful API for Team Share " )
			.version( "1.0" )
			.contact( 
					new Contact( "The A Team", "https://www.linksmt.it/a-team", "a-team@linksmt.it" ) )
			.build();
		// @formatter:on
	}

	@Override
	public void addResourceHandlers( ResourceHandlerRegistry registry ) {
		// @formatter:off
		registry
			.addResourceHandler( "swagger-ui.html" )
			.addResourceLocations( "classpath:/META-INF/resources/" );

		registry
			.addResourceHandler( "/webjars/**" )
			.addResourceLocations( "classpath:/META-INF/resources/webjars/" );
		// @formatter:on
	}
}