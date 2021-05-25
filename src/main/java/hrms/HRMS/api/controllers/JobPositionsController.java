package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.entities.concretes.JobPositions;
import hrms.HRMS.business.abstracts.JobPositionsService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;



@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

	private JobPositionsService jobPositionsService;

	@Autowired
	public JobPositionsController(JobPositionsService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPositions>> getAll(){
		return this.jobPositionsService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	}
	
}			
