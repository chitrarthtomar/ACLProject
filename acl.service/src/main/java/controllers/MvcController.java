package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import model.User;
import services.UserDao;
import services.UserService;

@Controller  
public class MvcController {  

	@Autowired
	UserService userService;
	
    @RequestMapping("/login")  
    public ModelAndView viewuser(){  
        System.out.println("working");
        userService.updateUser("EMP01", "Viggy GG");
        return new ModelAndView("redirect:/");
    }
 
}