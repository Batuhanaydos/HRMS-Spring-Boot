package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.JobPositionsService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessDataResult;
import hrms.HRMS.core.utilities.results.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.JobPositionsDao;
import hrms.HRMS.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService {

	private JobPositionsDao jobPositionDao;
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionDao = jobPositionsDao;
	}
	
	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>
		(this.jobPositionDao.findAll(),"Data Listelendi");
				
	}

	@Override
	public Result add(JobPositions jobPositions) {
		this.jobPositionDao.save(jobPositions);
		return new SuccessResult("Ürün Eklendi");
	}
}