package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	
}