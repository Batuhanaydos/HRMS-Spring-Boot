package hrms.HRMS.dataAccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions,Integer>{

}