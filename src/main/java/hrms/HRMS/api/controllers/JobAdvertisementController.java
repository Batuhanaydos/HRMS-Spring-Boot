package hrms.HRMS.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.JobAdvertisementService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.entities.concretes.JobAdvertisement;
import hrms.HRMS.entities.dtos.DisplayJobAdvertisementDto;
import hrms.HRMS.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAllJobAdvertisement")
	public DataResult<List<DisplayJobAdvertisementDto>> getAll() {
		return this.jobAdvertisementService.getAllDisplay();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getActiveJobAdvertisement")
	public DataResult<List<DisplayJobAdvertisementDto>> getByIsActive() {
		return this.jobAdvertisementService.getByIsActive(true);
	}
	
	
	@GetMapping("/getActiveAndDateJobAdvertisement")
	public DataResult<List<DisplayJobAdvertisementDto>> getByIsActiveAndReleaseDate(@RequestParam Date releaseDate) {
		
		return this.jobAdvertisementService.getByIsActiveAndReleaseDate(true, releaseDate);
	}
	
	@GetMapping("/getAllSortedJobAdvertisement")
	public DataResult<List<JobAdvertisementDto>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}

	@GetMapping("/getActiveCompanyJobAdvertisementList")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer(boolean isActive, int employerId) {
		return this.jobAdvertisementService.getByIsActiveAndEmployer_UserId(isActive, employerId);
	}

	@GetMapping("/ChangeActive")
	public DataResult<JobAdvertisementDto> updateActive(int jobAdvertisementId) {
		return this.jobAdvertisementService.updateActive(jobAdvertisementId);
	}
	
}