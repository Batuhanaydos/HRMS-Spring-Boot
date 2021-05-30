package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{
	boolean existsUserByEposta(String eposta);
}