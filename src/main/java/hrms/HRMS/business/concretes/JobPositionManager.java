package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.JobPositionService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.ErrorResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessDataResult;
import hrms.HRMS.core.utilities.results.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.JobPositionDao;
import hrms.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}




	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll());
	}




	@Override
	public Result add(JobPosition entity) {
		
		if(isExist(entity)) {
			return new ErrorResult("İş Pozisyonu zaten ekli!");
		}
		
		this.jobPositionDao.save(entity);
		return new SuccessResult("Meslek eklendi");
	}
	
	private boolean isExist(JobPosition entity) {
		return jobPositionDao.existsJobPositionByJobName(entity.getJobName());
	}
	
}