package cn.edu.seu.bigdata.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
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
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	@RequestMapping("/register")
	public String create(@RequestParam String name, @RequestParam String password, @RequestParam String confirm,ModelMap model) {
		
			try {
			userService.register(name, password, confirm);
		} catch (RegisterException e) {
			if (e.getMessage().equals("PASSWORD_TOO_EASY")){
				
				return "redirect:/index/register";
			}
			
		}
		return "redirect:/index/login";
	}

	@RequestMapping("/login")
	public String loginByAccount(@RequestParam String name, @RequestParam String password){
		   User user = null;
			try{
			 user =	userService.loginByAccoutAndPassword(name,password);
			} catch(LoginException e){
				e.printStackTrace();
			}
		   
			
			return  "redirect:/user/interest/?userid="+user.getId();
	}
	
	@RequestMapping("/nice")
	public ModelAndView showMain(){
		User user = null;
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("/user/nice");
		return mv;
	}
	@RequestMapping("/interest")
	public ModelAndView showInterest(@RequestParam Integer userid)
	{
		
		User user = userService.findUserByID(userid);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("/user/interest");
		return mv;
	}
	
	
}