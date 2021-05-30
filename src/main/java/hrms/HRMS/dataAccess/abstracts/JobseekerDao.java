package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer>{
	boolean existsJobseekerByTcNo(String tcno);
	boolean existsUserByEposta(String eposta);
}