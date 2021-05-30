package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
}