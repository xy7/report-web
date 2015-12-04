package com.seasun.report.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seasun.report.ReportWebApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReportWebApp.class)
public class TableControllerTest {

	@Autowired
	private JdbcTemplate jdbc;
	
	//@Test
	public void test() {
		System.out.println(jdbc.queryForList("select * from test"));
		System.out.println(jdbc.queryForList("select COLUMN_NAME, COLUMN_COMMENT from information_schema.columns where table_name='test'") );
		System.out.println(jdbc.queryForList("select TABLE_NAME, TABLE_COMMENT from information_schema.tables where table_type = 'BASE TABLE' and TABLE_SCHEMA='test'") );
	}

}
