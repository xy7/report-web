package com.seasun.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
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
	
	@RequestMapping("/showTables")
	public String showTables(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world!");
		List<Map<String, String>> list = new ArrayList<>();
		for(int i=0;i<5;i++){
			Map<String, String> tableUrls = new HashMap<>();
			tableUrls.put("name", "表"+i);
			tableUrls.put("url", "http://localhost/table/"+i);
			list.add(tableUrls);
		}
		model.put("list", "<br/>123<br/>");
		return "showTables";
    }

	
    public static void main(String[] args) throws Exception {
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
    	freemarker.template.Configuration conf = ctx.getBean(freemarker.template.Configuration.class);
    	FreeMarkerConfigurationUtil.setConfiguration(conf);

    	//defaultViewResolver,viewResolver,beanNameViewResolver,mvcViewResolver,freeMarkerViewResolver
 
    }   
    
}
