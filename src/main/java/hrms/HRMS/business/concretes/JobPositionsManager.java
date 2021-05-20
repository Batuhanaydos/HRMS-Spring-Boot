package hrms.HRMS.business.concretes;

import java.util.List;

import hrms.HRMS.dataAccess.concretes.JobPositionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.HRMS.business.abstracts.JobPositionsService;


@Service
public class JobPositionsManager implements JobPositionsService {

	private JobPositionsDao jobPositionDao;
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionDao = jobPositionsDao;
	}


	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
