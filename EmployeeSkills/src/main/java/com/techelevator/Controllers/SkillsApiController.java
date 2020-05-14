package com.techelevator.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.Dao.EmployeeDao;
import com.techelevator.Dao.FieldDao;
import com.techelevator.Dao.SkillsDao;
import com.techelevator.Model.Field;
import com.techelevator.Model.Skills;

@RestController
@CrossOrigin
@RequestMapping("/api/skills")
public class SkillsApiController {
	@Autowired
	private EmployeeDao employeeDAO;

	@Autowired
	private SkillsDao skillsDao;
	
	@Autowired
	private FieldDao fieldDao;

	@GetMapping("/{employeeID}​")
	public List<Skills> displayEmployeSkills(@PathVariable UUID employeeID) {
		
	List<Skills> employeeSkills = skillsDao.getAllSkillsByEmployeeID(employeeID);

	  for(Skills skill: employeeSkills) {
          UUID fieldId = skill.getFieldID();
          Field field = fieldDao.getFieldID(fieldId);
          skill.setField(field);
      }
      return employeeSkills;
  }

}

