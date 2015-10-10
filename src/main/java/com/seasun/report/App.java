package com.seasun.report;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
public class App {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world!");
		return "welcome";
    }
	
	
    public static void main(String[] args) throws Exception {
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
    	freemarker.template.Configuration conf = ctx.getBean(freemarker.template.Configuration.class);
    	System.out.println("1:"+conf.getTimeFormat());
    	FreeMarkerConfigurationUtil.setConfiguration(conf);
    	System.out.println("2:"+conf.getTimeFormat());
    }
    
    
}
