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

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/index")
public class indexController {
	
	@RequestMapping("/register" )
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/register");
		return mv;
	}
	
	@RequestMapping("/login" )
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;
	}
}
