package hrms.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobPositions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPositions {
		
		@Id
		@GeneratedValue
		@Column(name="job_id")
		private int id;
		@Column(name="department")
		private String department;
		@Column(name="salary")
		private double salary;
		@Column(name="offDayInOneYear")
		private int offDayInOneYear;
		
}