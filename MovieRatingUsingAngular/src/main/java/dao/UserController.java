package dao;



import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import dao.UserDetailsImpl;

@Controller
public class UserController {
	
	@Autowired
    private UserDetailsDAO userDetailsImpl;
	
	public UserController() {
        System.out.println("UserController() ran here");
    }
	
	@RequestMapping(value = "/bran")
    public ModelAndView listUsers(ModelAndView model) throws IOException {
		System.out.println("run method got called from tye click of submit query");
        List<UserDet> listUsers = userDetailsImpl.getAllUsers();
        model.addObject("listUsers", listUsers);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ModelAndView newContact(ModelAndView model) {
        UserDet userDet = new UserDet();
        model.addObject("userDet", userDet);
        model.setViewName("UserForm");
        return model;
    }
 
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUsers(@ModelAttribute UserDet user) {
        if (user.getUserId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            userDetailsImpl.addUser(user);
        } else {
        	userDetailsImpl.updateUser(user);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
        userDetailsImpl.deleteUsers(1);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("trying to edit record with useriud : "+ userId);
        UserDet user =userDetailsImpl.getUser(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
        return model;
    }
    
    
    @RequestMapping(value = "/insert")
    public ModelAndView createDataInAlreadyExisitingTable(ModelAndView model) throws IOException {
    	System.out.println("insert is getting called and now the insertion will be performed");
    	UserDet userDet = new UserDet();
    	userDet.setFirstName("jordan");
    	userDet.setLastName("joradan");
    	userDet.setEmail("something@gmail");
    	userDet.setPhoneNumber("12345");
    	try
    	{
    	userDet.setJoinDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2015"));
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	userDetailsImpl.insertUser(userDet);
        model.addObject("user", userDet);
        model.setViewName("home");
        return model;
    }
}
