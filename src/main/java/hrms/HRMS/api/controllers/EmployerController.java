package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAllEmployer")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	
	
}
