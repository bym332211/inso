package MySpringBoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.Test;


@Controller
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer{
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	logger.debug("**************************************configure**************************************");
        return builder.sources(this.getClass());
    }
    
	@RequestMapping("/home")
	@ResponseBody
	String home() {
		Test t = new Test();
		return (t.getStr());
	}
}
