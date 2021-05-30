package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.UserService;
import hrms.HRMS.core.utilities.results.DataResult;
import hrms.HRMS.entities.concretes.User;
import hrms.HRMS.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAllUsers")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/verify")
	public Result  Verify(int userId, String verifyCode) {
		return this.userService.Verify(userId, verifyCode);
	}
}