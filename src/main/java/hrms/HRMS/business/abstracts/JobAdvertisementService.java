package hrms.HRMS.business.abstracts;

import java.util.Date;
import java.util.List;

import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.entities.concretes.JobAdvertisement;
import hrms.HRMS.entities.dtos.DisplayJobAdvertisementDto;
import hrms.HRMS.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService extends BaseService<JobAdvertisement>{
	
	public Result add(JobAdvertisementDto entity);
	public DataResult<List<DisplayJobAdvertisementDto>> getAllDisplay();
	
	public DataResult<List<DisplayJobAdvertisementDto>> getByIsActive(boolean isActive);

	DataResult<List<DisplayJobAdvertisementDto>> getByIsActiveAndReleaseDate(boolean isActive, Date releaseDate);

	DataResult<List<JobAdvertisementDto>> getAllSorted();
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_UserId(boolean isActive, int employerId);
	
	DataResult<JobAdvertisementDto> updateActive(int jobAdvertisementId);
}