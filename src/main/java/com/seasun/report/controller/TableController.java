package com.seasun.report.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableController {
	
	private static final String _ID = "_id";
	private static final Log log = LogFactory.getLog(TableController.class);
	
	@RequestMapping("/test_welcome")
	public @ResponseBody String test() {
		return "welcome";
    }
	
	@Autowired
	private JdbcTemplate jdbc;

	@RequestMapping("/showTables")
	public String showTables(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "数据库中有如下表：");
		//从配置表中查出所有的表
		List<Map<String, Object>> list = jdbc.queryForList(
				"select TABLE_NAME tableName, TABLE_COMMENT tableComment from information_schema.tables "
				+ "where table_type = 'BASE TABLE' and TABLE_SCHEMA in ( select database()) ");
	
		model.put("list", list);
		
		return "showTables";
    }
	
	@RequestMapping(value="/editTableData/{tableName}", method = RequestMethod.GET)
	public String showTableData(Map<String, Object> model, @PathVariable("tableName") String tableName, HttpServletRequest request) {
		model.put("tableName", tableName);
		//从表中查出数据
		List<Map<String, Object>> columnList = jdbc.queryForList(
				"select COLUMN_NAME columnName, COLUMN_COMMENT columnComment from information_schema.columns "
				+ "where table_name='" + tableName + "'" + " and COLUMN_NAME != '" + _ID + "'"); 
		
		model.put("columnList", columnList);
		
		//从表中查出数据
		List<Map<String, Object>> searchList = jdbc.queryForList(
				"select COLUMN_NAME columnName, COLUMN_COMMENT columnComment from information_schema.columns "
				+ "where table_name='" + tableName + "'" + " and COLUMN_NAME != '" + _ID + "' and ORDINAL_POSITION in (2,3,4)");
		
		model.put("searchList", searchList);

		List<Map<String, Object>> dataList = jdbc.queryForList(
				"select * from " + tableName);
		
		model.put("dataList", dataList);

		return "../editTableData";
	}
	
	@RequestMapping(value="/editTableData/{tableName}", method = RequestMethod.POST)
	public String editTableData(Map<String, Object> model, @PathVariable("tableName") String tableName, HttpServletRequest request) {
		model.put("tableName", tableName);
		//从表中查出数据
		List<Map<String, Object>> columnList = jdbc.queryForList(
				"select COLUMN_NAME columnName, COLUMN_COMMENT columnComment from information_schema.columns "
				+ "where table_name='" + tableName + "'" + " and COLUMN_NAME != '" + _ID + "'"); 
		
		model.put("columnList", columnList);
		
		//从表中查出数据
		List<Map<String, Object>> searchList = jdbc.queryForList(
				"select COLUMN_NAME columnName, COLUMN_COMMENT columnComment from information_schema.columns "
				+ "where table_name='" + tableName + "'" + " and COLUMN_NAME != '" + _ID + "' and ORDINAL_POSITION in (2,3,4)");
		
		model.put("searchList", searchList);
		
		StringBuilder sb = new StringBuilder();
		for(Map<String, Object> m:searchList){
			String col = m.get("columnName").toString();
			String value = request.getParameter(col);
			if(value != null && !value.isEmpty()){
				sb.append(" and ").append(col).append("=").append("'").append(value).append("'");
			}
		}

		List<Map<String, Object>> dataList = jdbc.queryForList(
				"select * from " + tableName + " where 1=1 " + sb.toString());
		
		model.put("dataList", dataList);

		return "../editTableData";
	}
	
	@RequestMapping(value="/editTableData/editTableRow/update", method = RequestMethod.POST)
	public String editTableRow(HttpServletRequest request) {
		
		String tableName = request.getParameter("tableName");
		int id = Integer.parseInt(request.getParameter(_ID) );
		
		List<String> columnList = jdbc.queryForList(
				"select COLUMN_NAME columnName from information_schema.columns "
				+ "where table_name='"+tableName+"' and COLUMN_NAME != '" + _ID + "'", String.class);
		
		StringBuilder sb = new StringBuilder();

		for(String col:columnList){
			String value = request.getParameter(col);
			if(value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")){
				sb.append(",").append(col).append("=").append("'").append(value).append("'");
			}
		}
		
		String sql = "update " + tableName + " set " + sb.toString().substring(1) + " where " + _ID + "=" + id;
		System.out.println(sql);
		int res = jdbc.update(sql);
		log.info("update res: " + res);
		return "redirect:/editTableData/" + tableName;
	}
	
	@RequestMapping(value="/editTableData/editTableRow/insert", method = RequestMethod.POST)
	public String insertTableRow(HttpServletRequest request) {
		
		String tableName = request.getParameter("tableName");
		
		List<String> columnList = jdbc.queryForList(
				"select COLUMN_NAME columnName from information_schema.columns "
				+ "where table_name='"+tableName+"' and COLUMN_NAME != '" + _ID + "'", String.class);
		
		StringBuilder sbCol = new StringBuilder();
		StringBuilder sbValue = new StringBuilder();

		for(String col:columnList){
			String value = request.getParameter(col);
			if(value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")){
				sbCol.append(",").append(col);
				sbValue.append(",").append("'").append(value).append("'");
			}
		}
		
		String sql = "insert into " + tableName + " (" + sbCol.toString().substring(1) 
				+ ") values( " + sbValue.toString().substring(1) + ")" ;
		System.out.println(sql);
		int res = jdbc.update(sql);
		log.info("insert res: " + res);
		
		return "redirect:/editTableData/" + tableName;
	}
	
	@RequestMapping(value="/editTableData/editTableRow/delete", method = RequestMethod.POST)
	public String deleteTableRow(HttpServletRequest request) {
		
		String tableName = request.getParameter("tableName");
		int id = Integer.parseInt(request.getParameter(_ID) );
		
		String sql = "delete from " + tableName + " where " + _ID + "=" + id;
		System.out.println(sql);
		int res = jdbc.update(sql);
		log.info("delete res: " + res);
		return "redirect:/editTableData/" + tableName;
	}

}
