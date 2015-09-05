package cn.edu.seu.bigdata.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.exception.LoginException;
import cn.edu.seu.bigdata.exception.RegisterException;
import cn.edu.seu.bigdata.service.UserManageService;




import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserManageService userService;

	@Autowired
	public void setUserService(UserManageService userManageService) {
		this.userService = userManageService;
	}

	@RequestMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Integer id, HttpServletRequest req) {

		User user = userService.findUserByID(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	@RequestMapping("/register")
	public String create(@RequestParam String name, @RequestParam String password, @RequestParam String confirm) {
		
			try {
			userService.register(name, password, confirm);
		} catch (RegisterException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String loginByAccount(@RequestParam String name, @RequestParam String password){
			
			try{
				userService.loginByAccoutAndPassword(name,password);
			} catch(LoginException e){
				e.printStackTrace();
			}
			return  "redirect:/nice";
	
	}
}
