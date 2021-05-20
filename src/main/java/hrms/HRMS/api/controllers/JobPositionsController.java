package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.entities.concretes.JobPositions;
import hrms.HRMS.business.abstracts.JobPositionsService;



@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

	private JobPositionsService jobPositionsService;

	@Autowired
	public JobPositionsController(JobPositionsService jobPositionsService) {
		this.jobPositionsService = jobPositionsService;
	}

	@GetMapping("/getall")
	public List<JobPositions> getAll(){
		return List.of(new JobPositions(
				1,"Management",15000,15
		));
		
	}
}
			
