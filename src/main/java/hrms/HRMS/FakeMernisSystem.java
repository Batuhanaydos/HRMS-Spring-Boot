package hrms.HRMS;
import java.time.LocalDate;

public class FakeMernisSystem {
	
		public boolean userValidationWithMernis(String firstName, String lastName, String nationalId, LocalDate birthOfDate) {

			boolean result = false;
			if (nationalId.length() == 11 && birthOfDate.getYear() < 2000 && birthOfDate.getYear() > 1950) {
				result = true;
				System.out.println("User validation: SUCCESS. " + firstName + " " + lastName);
			} else {
				result = false;
				System.out.println("User validation: ERROR. " + firstName + " " + lastName);
			}
			return result;
		}
	}
