package com.seasun.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
    public static void main(String[] args) throws Exception {
    	ApplicationContext ctx = SpringApplication.run(ReportWebApp.class, args);
    	freemarker.template.Configuration conf = ctx.getBean(freemarker.template.Configuration.class);
    	FreeMarkerConfigurationUtil.setConfiguration(conf);

 
    }   
    
}
