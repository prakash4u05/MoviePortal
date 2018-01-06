package com.applesample.SpringMoviePortal.Controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applesample.SpringMoviePortal.Beans.Movies;
import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAO;
import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAOImpl;

//@Path("/rest")
@RestController
public class MoviesRestController {
	
	//@GET
	//@Path("/checkinfo")
	
	@Autowired
	MoviesDatabaseDAO repository;

	
	@GetMapping("/Movies/{Moviename}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Movies> getMovieinfo(final @PathVariable("Moviename") String MovieName)
	{
		Movies genericentity = repository.getMovieInfo(MovieName);//getMovieTitles()){};
		//System.out.println("inhere"+genericentity.getDateIssued());
		//return Response.ok(genericentity).build();
		return new ResponseEntity<Movies>(genericentity,HttpStatus.OK);
	}
	
	@GetMapping("/Movies")
	//@RequestMapping("/Movies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMovieinfo()
	{
		
		//GenericEntity<List<Movies>> movieEntity = new GenericEntity<List<Movies>>(repository.getAllMoviesInfo()){};
		List<Movies> movieEntity=new ArrayList<>(repository.getAllMoviesInfo());
		//System.out.println(movieEntity.getEntity());
		return Response.ok().entity(movieEntity).build();
		
	}
	@GetMapping("/MoviesNames")
	//@RequestMapping("/Movies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMovieList()
	{
		
		//GenericEntity<List<Movies>> movieEntity = new GenericEntity<List<Movies>>(repository.getAllMoviesInfo()){};
		System.out.println("movierep"+repository);
		List<Movies> movieLsit=new ArrayList<>();
		movieLsit=repository.getmoviesList();
		System.out.println("movieList"+movieLsit);
		return Response.ok().entity(movieLsit).build();
		
	}
	@GetMapping("/MoviesNames/{id}")
	//@RequestMapping("/Movies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOptionsMovieList(final @PathVariable("id") String MovieName)
	{
		
		//GenericEntity<List<Movies>> movieEntity = new GenericEntity<List<Movies>>(repository.getAllMoviesInfo()){};
		List<Movies> movieLsit=new ArrayList<>(repository.getmoviesOptionsList(MovieName));
		//System.out.println(movieEntity.getEntity());
		return Response.ok().entity(movieLsit).build();
		
	}
 // public 
	@RequestMapping(value = "Rent/{id}", method = RequestMethod.POST)
	public Response setAllMovierent(final @PathVariable("id") String Movieid,HttpSession session)
	{
		System.out.println(session.getAttribute("uname"));
		System.out.println("Movie rented is  "+Movieid);
		repository.insertmovieinUserdata(Movieid, (String)session.getAttribute("uname"));
		return Response.status(204).build();
	}
	

}
