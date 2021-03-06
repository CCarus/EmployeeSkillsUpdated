package com.techelevator.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.Dao.SkillsDao;
import com.techelevator.Model.Skills;

@RestController
@CrossOrigin
@RequestMapping("/api/skills")
public class SkillsApiController {
	

	@Autowired
	private SkillsDao skillsDao;

	@GetMapping("/{employeeID}")
	public List<Skills> displayEmployeSkills(@PathVariable UUID employeeID) {
		
	List<Skills> employeeSkills = skillsDao.getAllSkillsByEmployeeID(employeeID);

	return employeeSkills;

}
}
