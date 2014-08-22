package springWeb;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class TestController {
	
	ArrayList<User> userList;
	protected static Logger logger = Logger.getLogger("springWeb");
	@Autowired
	private UserDAO userDAO;
	private UserEntity user;
	
	TestController() {
		
		userList = new ArrayList<>();
		userList.add( new User("Bartek", "Kradziej", "Kradziej@mail.ru") );
		userList.add( new User("Michal", "Molu", "Molu@mail.ru") );
		userList.add( new User("Mateusz", "BijcieMasterczulki", "mistrzu@wp.pl") );
		
		user = new UserEntity();
		user.setImie("Bartek");
		
	}
 
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
		
		userDAO.addUser(user);
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "hello";
 
	}
 
	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
		return "hello";
 
	}
 
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		
		model.addAttribute("personForm", "search.html");
		return "index";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET) 
	public ModelAndView userPage(@PathVariable int id) {
		
		
		if(userList.size() < id || id == 0) {
			ModelAndView model = new ModelAndView("userNotExist");
			model.addObject("id", id);
			return model;
		}
		
		ModelAndView model = new ModelAndView("user");
		User u = userList.get(id - 1);
		model.addObject("userName", u.getName());
		model.addObject("userNick", u.getNick());
		model.addObject("userEmail", u.getEmail());
		
		return model;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET) 
	public String showSearchForm(ModelMap model) {
		
		logger.log(Level.INFO, "w searchu");
		model.addAttribute("user", new User());
		return "personForm";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchUser(@ModelAttribute User user) {
		
		// Pusty string gdy nie zostanie ustawiona wartosc przez setter
		
		int index = userList.indexOf(user);
		
		if(index == -1) {
			ModelAndView model = new ModelAndView("personForm");
			if(user.getName() != "") {
				model.addObject( "errorMsg1", "User with name " + user.getName() + " doesn't exist" );
			}
			if(user.getNick() != "") {
				model.addObject( "errorMsg2", "User with nick " + user.getNick() + " doesn't exist" );
			}
		
			return model;
		}
		
		ModelAndView model = new ModelAndView();
		model.setView( new RedirectView("user/" + (index + 1) + ".html", true) );
		return model;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
