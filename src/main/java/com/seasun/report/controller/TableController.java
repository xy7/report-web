package com.seasun.report.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {
	
	@Autowired
	private JdbcTemplate jdbc;

	@RequestMapping("/showTables")
	public String showTables(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "数据库中有如下表：");
		//从配置表中查出所有的表
		List<Map<String, Object>> list = jdbc.queryForList(
				"select TABLE_NAME tableName, TABLE_COMMENT tableComment from information_schema.tables "
				+ "where table_type = 'BASE TABLE' and TABLE_SCHEMA='test'");
	
		model.put("list", list);
		
		return "showTables";
    }
	
	@RequestMapping("/editTableData/{tableName}")
	public String editTableData(Map<String, Object> model, @PathVariable("tableName") String tableName) {
		model.put("tableName", tableName);
		//从表中查出数据
		List<Map<String, Object>> columnList = jdbc.queryForList(
				"select COLUMN_NAME columnName, COLUMN_COMMENT columnComment from information_schema.columns "
				+ "where table_name='"+tableName+"'"); 
		
		model.put("columnList", columnList);
		
		List<Map<String, Object>> dataList = jdbc.queryForList(
				"select * from "+tableName);
		
		model.put("dataList", dataList);

		return "editTableData";
	}

}
