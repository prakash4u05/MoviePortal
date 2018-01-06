package com.applesample.SpringMoviePortal.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.applesample.SpringMoviePortal.Beans.Movies;
import com.applesample.SpringMoviePortal.Beans.Users;
import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.util.SystemInfo;

@Controller
//@RequestMapping("/")
//@SessionAttributes("uname")
public class MoviesController {
	
	@Autowired
	MoviesDatabaseDAO repository;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("message", "Movie Portal");
		//model.addAttribute("uname", "New User");
		session.invalidate();
		session.setAttribute("uname", "");
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String firstPage(Model model) {
		model.addAttribute("message", "Movie Portal");
		//model.addAttribute("uname", "New User");
		//session.invalidate();
		//session.setAttribute("uname", "");
		
		return "index";
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView LoginPage()
	{
		return new ModelAndView("Login");
	}	
	@RequestMapping("/logout")
	public String Logout()
	{
		
		session.invalidate();
		return "redirect:/index";
	}	
	@RequestMapping("/login")
	public String Login(final @RequestParam("uname") String username,final @RequestParam("psw") String passWord ,Model model)
	{
		//String username="";
		
		Users userObj;
		try{
		userObj=repository.validateUser(username,passWord);
		System.out.println("useremail"+username+"PWD"+passWord+"uname"+userObj.getFirstName());
		
	    session.setAttribute("uname", userObj.getFirstName());
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return "Login";
		}
		
		model.addAttribute("message", "Movie Portal");
		return "index";
	}
     @RequestMapping("/register")
	public ModelAndView RegisterPage()
	{
		return new ModelAndView("RegisterUser");
	}
	@RequestMapping("/movielist")
	public String otherPage(Model ModelObj) throws IOException
	{
		//ClientResource client =new C
		
		RestTemplate restTemplate = new RestTemplate();
		List<Map<String, Object>> mList=new ArrayList<>();
		//Movies[] movieObj=new Movies[4];
       // movieObj =restTemplate.getForObject("http://localhost:8080/Movies/Matrix", Movies.class);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/MoviesNames",String.class);
        System.out.println("of"+response.getBody());//+movieObj.getMovieTitle());
       ObjectMapper mapper = new ObjectMapper();
        
        try{
        JsonNode root = mapper.readTree(response.getBody());
       JsonNode name = root.path("entity");//.path("dateIssued");
       for (JsonNode jsonNode : name) {
		
    	  // mList.add(new Movies(jsonNode.get("movieTitle"),jsonNode.get("moviePrice")));
    	   Map<String, Object> result = mapper.convertValue(jsonNode,Map.class);
    	   mList.add(result);
     
        System.out.println("Me"+jsonNode.get("movieTitle")+mList);
        }	}
       catch(JsonProcessingException j){}
        
        ModelObj.addAttribute("Listmap",mList);
		return "Movielist";
	}
	@RequestMapping("/movielist/{id}")
	public String OptionsPage(@PathVariable("id") String id,Model ModelObj) throws IOException
	{
		//ClientResource client =new C
		
		RestTemplate restTemplate = new RestTemplate();
		List<Map<String, Object>> mList=new ArrayList<>();
		//Movies[] movieObj=new Movies[4];
       // movieObj =restTemplate.getForObject("http://localhost:8080/Movies/Matrix", Movies.class);
		System.out.println("id" + id);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/MoviesNames/"+id,String.class);
        System.out.println("of"+response.getBody());//+movieObj.getMovieTitle());
       ObjectMapper mapper = new ObjectMapper();
        
        try{
        JsonNode root = mapper.readTree(response.getBody());
       JsonNode name = root.path("entity");//.path("dateIssued");
       for (JsonNode jsonNode : name) {
		
    	  // mList.add(new Movies(jsonNode.get("movieTitle"),jsonNode.get("moviePrice")));
    	   Map<String, Object> result = mapper.convertValue(jsonNode, Map.class);
    	   mList.add(result);
     
        System.out.println("Me"+jsonNode.get("movieTitle")+mList);
        }	}
       catch(JsonProcessingException j){}
        
        ModelObj.addAttribute("Listmap",mList);
		return "Movielist";
	}
//	@RequestMapping()
//	public ModelAndView HomePage()
//	{
//		return new ModelAndView();
//	}
	
	 @RequestMapping("/users/{userid}")
		public String Userdetails(Model model,final @PathVariable("userid") String userid)
		
		{
		 	Users user=repository.getUserdetails(userid);
		 	model.addAttribute("User",user);
			return "Userdetails";
		}

}
