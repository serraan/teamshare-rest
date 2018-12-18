package it.linksmt.teamshare.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("it.linksmt.teamshare.business.services, it.linksmt.teamshare.business.services.impl")
public class AppConfig {

}
