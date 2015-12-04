package com.seasun.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//@Controller
//@ComponentScan(basePackages = "com.seasun.report")
//@Configuration
//@EnableAutoConfiguration
//public class ReportWebApp {
//
//	@RequestMapping("/")
//	public String test(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", "hello world!");
//		return "welcome";
//    }
//	
//	@RequestMapping("/index")
//	public String home(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", "hello world!");
//		return "home";
//    }
//	
//    public static void main(String[] args) throws Exception {
//    	ApplicationContext ctx = SpringApplication.run(ReportWebApp.class, args);
//    	freemarker.template.Configuration conf = ctx.getBean(freemarker.template.Configuration.class);
//    	FreeMarkerConfigurationUtil.setConfiguration(conf);
//
// 
//    }   
//    
//}

@SpringBootApplication
public class ReportWebApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ReportWebApp.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ReportWebApp.class, args);
	}

}
