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

@Controller  
public class MvcController {  
    @Autowired  
    UserDao dao;  

//    @RequestMapping("/")  
//    public ModelAndView initPage(){  
//        return new ModelAndView("webUI");  
//    }
//
//    @RequestMapping("/empForm")  
//    public ModelAndView showform(){  
//        return new ModelAndView("empForm","command",new Employee());  
//    }  
//
//    @RequestMapping(value="/save",method = RequestMethod.POST)  
//    public ModelAndView save(@ModelAttribute("emp") Employee emp){  
//        dao.addEmployee(emp);  
//        return new ModelAndView("redirect:/viewemp");
//    }  
// 
    @RequestMapping("/viewuser")  
    public void viewuser(){  
        List<User> list=dao.getAllUsers();  
        System.out.println("working");
        return;
    }
//    @RequestMapping("/view5emp")  
//    public ModelAndView view5emp(){  
//        ArrayList<Employee> list=new ArrayList<>();
//        list.add(dao.get5thEmployeebyAge());
//        System.out.println(list.get(0));
//        return new ModelAndView("viewemp","list",list);  
//    }
//    
//    @RequestMapping(value="/empeditform/{id}")
//	public ModelAndView edit(@PathVariable int id){
//		Employee emp=dao.getEmpById(id);
//		return new ModelAndView("empeditform","command",emp);
//	}
//
//    @RequestMapping(value="empeditform/editsave",method = RequestMethod.POST)  
//    public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
//        dao.updateEmployee(emp);  
//        return new ModelAndView("redirect:/viewemp");  
//    }  
}