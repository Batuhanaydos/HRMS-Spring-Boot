package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.Personel;

public interface PersonelDao extends JpaRepository<Personel, Integer>{

}