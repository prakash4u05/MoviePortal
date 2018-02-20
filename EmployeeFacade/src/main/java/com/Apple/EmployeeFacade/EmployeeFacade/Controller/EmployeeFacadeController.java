package com.Apple.EmployeeFacade.EmployeeFacade.Controller;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Apple.EmployeeFacade.EmployeeFacade.Model.Employee;
import com.Apple.EmployeeFacade.EmployeeFacade.Service.EmployeeFacadeService;

@RequestMapping("/EmpFacade")
@Controller
public class EmployeeFacadeController {
	
	@Autowired
	EmployeeFacadeService employeeFacadeService;

	/*Mapping for Employee Search*/
	@ResponseBody
	@RequestMapping(value="searchEmployee/Search",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeBynameordept(@QueryParam("dept") String dept,@QueryParam("name") String name) throws IOException
	{
		
		List<Employee> returnVal=employeeFacadeService.Getemployeebynameanddept(dept, name);
		return returnVal;
	}
	
	/*Mapping for Employee Post Request*/
	@ResponseBody
	@RequestMapping(value="addEmployees",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createEmploye(@RequestBody Employee employee)
	{
		employeeFacadeService.createEmployee(employee);
	}
	
	/*Mapping for Employee Update*/
	@ResponseBody
	@RequestMapping(value="updateEmployees",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void UpadteEmploye(@RequestBody Employee employee)
	{
		//System.out.println("in put");
		employeeFacadeService.updateEmployee(employee);
	}
	
	/*Mapping for Employee Search*/
	@ResponseBody
	@RequestMapping(value="/getEmployee/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("id") String id) throws IOException
	{
		//System.out.println("inside get"+id);
		Employee returnVal=employeeFacadeService.Getemployee(id);
		
		
		return returnVal;
	}
	
	/*Mapping for View Navigations*/
	@RequestMapping("/getemp")
	public String search(Model model) {
		
		return "index";
	}
	@RequestMapping("/index")
	public String indexPage(Model model) {
		//System.out.println("Inside index");
		model.addAttribute("message", "Employee UI");	
		return "start";
	}
	@RequestMapping("/AddDetails")
	public ModelAndView addPage()
	{
		return new ModelAndView("addDetails");
	}
	@RequestMapping("/empSearch")
	public ModelAndView searchPage()
	{
		return new ModelAndView("empSearch");
	}
	@RequestMapping("/Update")
	public ModelAndView UpdatePage()
	{
		return new ModelAndView("Update");
	}
	
	
}
