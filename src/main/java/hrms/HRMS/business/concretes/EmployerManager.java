package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.EmployerService;

import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.ErrorDataResult;
import hrms.HRMS.core.utilities.results.ErrorResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessDataResult;
import hrms.HRMS.core.utilities.results.SuccessResult;
import hrms.HRMS.core.utilities.results.helpers.CheckHelper;
import hrms.HRMS.dataAccess.abstracts.EmployerDao;
import hrms.HRMS.entities.concretes.Employer;
import hrms.HRMS.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private UserManager userManager;
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserManager userManager) {
		this.employerDao = employerDao;
		this.userManager = userManager;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer entity) {
		

		if(isNull(entity)) {
			return new ErrorDataResult<Employer>("Tüm alanları doldurunuz!");
		}
		
		if(!CheckHelper.emailCheck(entity.getEposta())) {
			return new ErrorResult("E-posta hatalı!");
		}
		 
		String domain = entity.getEposta().split("@")[1];
		if(!domain.startsWith(entity.getCompanyName())) {
			return new ErrorResult("Lütfen şirket adınıza kayıtlı e posta kullanınız!");
		}
		
		
		if(isExist(entity)) {
			return new ErrorResult("E posta kayıtlı!");
		}
		
		
		DataResult<User> result = (DataResult<User>) userManager.add((User)entity);
		if(result.isSuccess()) {
			entity.setUserId(result.getData().getUserId());
			this.employerDao.save(entity);
			return new SuccessResult("İş Veren eklendi");
		}
		
		return new ErrorResult("Kayıt başarısız!");
		
	}
	private boolean isNull(Employer entity) {
		return (entity.getEposta().isEmpty() || entity.getCompanyName().isEmpty() || entity.getPassword().isEmpty() || entity.getPhone().isEmpty() || entity.getWebsite().isEmpty());
	}
	
	private boolean isExist(Employer entity) {
		return employerDao.existsUserByEposta(entity.getEposta());
	}
	
	
	
}