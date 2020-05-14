package com.techelevator.Dao;

import java.util.List;
import java.util.UUID;

import com.techelevator.Model.Field;

public interface FieldDao {

	List<Field> displayAllFields();

	void createNewField(Field field);

	void removeFieldByFieldID(UUID fieldID);

	Field getFieldID(UUID fieldId);


	}


