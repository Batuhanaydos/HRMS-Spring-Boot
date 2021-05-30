package hrms.HRMS.entities.dtos;

import java.util.Date;
import java.util.List;

import hrms.HRMS.entities.concretes.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private String description;
	private int minSalary;
	private int maxSalary;
	private int maxPerson;
	private Date deadline;
	private boolean isActive;
	private String cityName;
	private int jobPositionId;
	private int employerId;
}