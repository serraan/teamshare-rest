package it.linksmt.teamshare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource( value = { "classpath:/git.properties" }, ignoreResourceNotFound = true )
public class TeamShareApplication {
	private static final String UNKNOWN = "<unknown>";
	private static final Logger LOG = LoggerFactory.getLogger( TeamShareApplication.class );

	public static void main( String[] args ) {
		SpringApplication.run( TeamShareApplication.class, args );
	}

	@Autowired
	private Environment environment;

	@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
		LOG.info( "\n\tBuilt by {}@{} on {}\n\tSCM Info: {} ({} {})",
				environment.getProperty( "git.build.user.name", UNKNOWN ),
				environment.getProperty( "git.build.host", UNKNOWN ),
				environment.getProperty( "git.build.time", UNKNOWN ),
				environment.getProperty( "git.branch", UNKNOWN ),
				environment.getProperty( "git.commit.id", UNKNOWN ),
				environment.getProperty( "git.commit.message.short", UNKNOWN )
		);
    }
}



