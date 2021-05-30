package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.UserRegister;

public interface UserRegisterDao extends JpaRepository<UserRegister, Integer>{

}