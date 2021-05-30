package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.UserService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessDataResult;
import hrms.HRMS.dataAccess.abstracts.UserDao;
import hrms.HRMS.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserRegisterManager userRegisterManager;
	@Autowired
	public UserManager(UserDao userDao, UserRegisterManager userRegisterManager) {
		super();
		this.userDao = userDao;
		this.userRegisterManager = userRegisterManager;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll());
	}
	
	@Override
	public Result add(User entity) {
		
		this.userDao.save(entity);
		userRegisterManager.NewRegister(entity);
		
		return new SuccessDataResult<User>(entity, "Kullanıcı eklendi");
	}

	@Override
	public Result Verify(int userId, String code) {
		return userRegisterManager.Verify(userId, code);
	}

	

	
	
	
}