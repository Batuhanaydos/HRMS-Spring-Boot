package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.entities.concretes.JobPositions;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;


public interface JobPositionsService {

	DataResult<List<JobPositions>> getAll();
	Result add(JobPositions JobPositions);
}