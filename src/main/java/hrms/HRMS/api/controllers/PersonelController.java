package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.PersonelService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.entities.concretes.Personel;

@RestController
@RequestMapping("/api/personels")
public class PersonelController {
	private PersonelService personelService;

	@Autowired
	public PersonelController(PersonelService personelService) {
		super();
		this.personelService = personelService;
	}
	
	@GetMapping("/getAllUsers")
	public DataResult<List<Personel>> getAll() {
		return this.personelService.getAll();
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Personel personel) {
		return this.personelService.add(personel);
	}
	
}	