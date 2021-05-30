package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.PersonelService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessDataResult;
import hrms.HRMS.core.utilities.results.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.PersonelDao;
import hrms.HRMS.entities.concretes.Personel;

@Service
public class PersonelManager implements PersonelService {

	private PersonelDao personelDao;
	
	@Autowired
	public PersonelManager(PersonelDao personelDao) {
		super();
		this.personelDao = personelDao;
	}
	
	@Override
	public DataResult<List<Personel>> getAll() {
		return new SuccessDataResult<List<Personel>>
		(this.personelDao.findAll());
	}

	@Override
	public Result add(Personel entity) {
		this.personelDao.save(entity);
		
		
		
		return new SuccessResult("Sistem Personeli eklendi");
	}

	
	
}