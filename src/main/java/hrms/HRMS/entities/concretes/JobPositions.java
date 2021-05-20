package hrms.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobPositions")
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
		
		public JobPositions() {
		}
		public JobPositions(int id, String department, double salary, int offDayInOneYear) {
			super();
			this.id = id;
			this.department = department;
			this.salary = salary;
			this.offDayInOneYear = offDayInOneYear;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public int getOffDayInOneYear() {
			return offDayInOneYear;
		}
		public void setOffDayInOneYear(int offDayInOneYear) {
			this.offDayInOneYear = offDayInOneYear;
		}
		
}

