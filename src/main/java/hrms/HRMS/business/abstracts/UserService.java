package hrms.HRMS.business.abstracts;

import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.entities.concretes.User;

public interface UserService extends BaseService<User>{
	public Result Verify(int userId, String code);
}