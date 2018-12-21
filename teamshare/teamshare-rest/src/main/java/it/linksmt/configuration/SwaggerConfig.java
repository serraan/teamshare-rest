package it.linksmt.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {   
	//	 /**
	//     * AUTHORIZATION_SCOPE_GLOBAL_DESC
	//     */
	//    public static final String AUTHORIZATION_SCOPE_GLOBAL_DESC = "accessEverything";
	    /**
	     * SECURITY_SCHEMA
	     */
	    public static final String SECURITY_SCHEMA = "Authorization";
	//    /**
	//     * BEARER
	//     */
	//    public static final String BEARER = "Bearer";
	//    /**
	//     * AUTHORIZATION_SCOPE_GLOBAL
	//     */
	//    public static final String AUTHORIZATION_SCOPE_GLOBAL = "global";

	@Bean
	public Docket api() { 		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, errorList())
				.globalResponseMessage(RequestMethod.POST, errorList())
				.globalResponseMessage(RequestMethod.PUT, errorList())
				.globalResponseMessage(RequestMethod.DELETE, errorList());
	}
	private List<ResponseMessage> errorList() {
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
	}
	
	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("TeamShare REST API","Servizi rest per l'applicazione TeamShare","1.0",null,null,null,null);
		return apiInfo;
	}
}
