package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.entities.concretes.JobPositions;

public interface JobPositionsService {
	List<JobPositions> getAll();
}
