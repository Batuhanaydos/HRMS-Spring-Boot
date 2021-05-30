package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

	boolean existsJobPositionByJobName(String jobName);
}