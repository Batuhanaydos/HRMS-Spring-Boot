package hrms.HRMS.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.UserRegisterService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.core.utilities.results.ErrorResult;
import hrms.HRMS.core.utilities.results.Result;
import hrms.HRMS.core.utilities.results.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.UserRegisterDao;
import hrms.HRMS.entities.concretes.User;
import hrms.HRMS.entities.concretes.UserRegister;

@Service
public class UserRegisterManager implements UserRegisterService  {

	private UserRegisterDao userRegisterDao;
	
	@Autowired
	public UserRegisterManager(UserRegisterDao userRegisterDao) {
		this.userRegisterDao = userRegisterDao;
	}
	
	@Override
	public DataResult<List<UserRegister>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(UserRegister entity) {
		userRegisterDao.save(entity);
		
		return new SuccessResult("Kayıt oluşturuldu!");
	}

	
	public Result NewRegister(User user) {
		UserRegister userRegister = new UserRegister();
		
		userRegister.setUserId(user.getUserId());
		userRegister.setComfirmed(false);
		
		
		Random rand = new Random();
		String code = String.format("%04d", 1000+ rand.nextInt(9000));
		userRegister.setActivisionCode(code);
		userRegister.setRegisterDate(new Date());
		return this.add(userRegister);
		
	}
	
	public Result Verify(int userId, String code) {
		List<UserRegister> registers = userRegisterDao.findAll();
		if(code.isEmpty()) {
			return new ErrorResult("Tüm alanları giriniz!");
		}
		for(UserRegister register : registers) {
			if(register.getUserId() == userId) {
				
				if(register.isComfirmed()) {
					return new ErrorResult("Zaten kaydınız tamamlanmış!");
				}
				
				if(register.getActivisionCode().equals(code)) {
					register.setComfirmed(true);
					register.setComfirmedDate(new Date());
					userRegisterDao.save(register);
					return new SuccessResult("Kullanıcı aktivasyon tamamlandı!");
				}
				else {
					return new ErrorResult("Aktivasyon kodu hatalı!");
				}
			}
		}
		
		return new ErrorResult("Kullanıcı  bulunamadı!");
	}
	
	
}