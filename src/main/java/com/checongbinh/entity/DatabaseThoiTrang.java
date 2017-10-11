package com.checongbinh.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseThoiTrang {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void getListNhanVien(){
		String sql = "select * from NhanVien";
		List<NhanVien> listNhanVien = jdbcTemplate.query(sql, new RowMapper<NhanVien>(){

			@Override
			public NhanVien mapRow(ResultSet rowResult, int arg1) throws SQLException {
				NhanVien nv = new NhanVien();
				nv.tennhanvien = rowResult.getString("tenNhanVien");
				nv.tuoi = rowResult.getInt("tuoi");
				return nv;
			}
			
		});
		
		for(NhanVien valueNv : listNhanVien){
			System.out.println("Gia tri : " + valueNv.tennhanvien + " - " + valueNv.tuoi);
		}
	
	}
}
