package com.techelevator.Jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Dao.FieldDao;
import com.techelevator.Model.Field;

@Component
public class JdbcFieldDao implements FieldDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    public JdbcFieldDao(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	 @Override
	 public List <Field> displayAllFields() {
		 List <Field> allFields = new ArrayList<>();
		 String sql = "SELECT * FROM field";
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		 while(results.next()) {
			 Field field = mapRowToField(results);
				allFields.add(field); 
			 
		 }
		return allFields;
	 }
	 
	 @Override
	 public void createNewField(Field field) {
		 String sql = "INSERT INTO field (field_name, type_of_technical_field) VALUES"
					+ "(?,?)";
			jdbcTemplate.update(sql, field.getFieldName(), field.getTypeOfTechnicalField());
			}
	 
	 @Override
	 public void removeFieldByFieldID(UUID fieldID) {
		 String sqlRemoveField = "DELETE * FROM field WHERE field_id = ?";
		 jdbcTemplate.update(sqlRemoveField, fieldID);
	 
	 }

	private Field mapRowToField(SqlRowSet results) {
		Field field = new Field();
		field.setFieldID((UUID)results.getObject("field_id"));
		field.setFieldName(results.getString("field_name"));
		field.setTypeOfTechnicalField(results.getString("type_of_technical_field"));
		
		return field;
	}

	@Override
	public Field getFieldID(UUID fieldId) {
		Field field = new Field();
		String sql = "SELECT field_id WHERE field_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fieldId);
		  while(results.next()){
			  field.getFieldID();
			  field.getFieldName();
			  field.getTypeOfTechnicalField();
		  }
		return field;
	}
	 
	 
}
