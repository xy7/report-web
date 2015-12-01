package com.seasun.report.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {

	@RequestMapping("/showTables")
	public String showTables(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world!");
		List<Map<String, String>> list = new ArrayList<>();//从配置表中查出所有的表
		for(int i=0;i<5;i++){
			Map<String, String> tableUrls = new HashMap<>();
			String tableName = "table_" + i;
			tableUrls.put("name", tableName);
			tableUrls.put("url", "http://localhost/editTableData/"+tableName);
			list.add(tableUrls);
		}
		model.put("list", list);
		
		List<String> list2 = new ArrayList<>();
		for(int i=0;i<5;i++)
			list2.add("table" + i);
		model.put("list2", list2);
		return "showTables";
    }
	
	@RequestMapping("/editTableData/{tableName}")
	public String editTableData(Map<String, Object> model, @PathVariable("tableName") String tableName) {
		System.out.println(tableName);
		List<Map<String, String>> list = new ArrayList<>(); //从表中查出数据
		for(int i=0;i<5;i++){
			Map<String, String> row = new HashMap<>();
			row.put("col", "k_" + i);
			row.put("col2", "c2_" + i);
			list.add(row);
		}
		model.put("list", list);

		return "editTableData";
	}

}
