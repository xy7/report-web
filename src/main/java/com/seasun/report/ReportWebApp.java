package com.seasun.report;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.reportengine.util.FreeMarkerConfigurationUtil;



@Controller
@ComponentScan(basePackages = "com.seasun.report")
@Configuration
@EnableAutoConfiguration
public class ReportWebApp {

	@RequestMapping("/")
	public String test(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world!");
		return "welcome";
    }
	
	@RequestMapping("/index")
	public String home(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world!");
		return "home";
    }
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setUriEncoding("UTF-8");
		File webappFile = new File("./src/main/webapp/WEB-INF/jsp");
		if (webappFile.isDirectory()) {
			factory.setDocumentRoot(webappFile);
		}

		return factory;
	}
	
    public static void main(String[] args) throws Exception {
    	ApplicationContext ctx = SpringApplication.run(ReportWebApp.class, args);
    	freemarker.template.Configuration conf = ctx.getBean(freemarker.template.Configuration.class);
    	FreeMarkerConfigurationUtil.setConfiguration(conf);

 
    }   
    
}

////war包
//@SpringBootApplication
//public class ReportWebApp extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ReportWebApp.class);
//	}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(ReportWebApp.class, args);
//	}
//
//}
