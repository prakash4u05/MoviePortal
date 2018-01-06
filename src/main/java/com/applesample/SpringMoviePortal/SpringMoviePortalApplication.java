package com.applesample.SpringMoviePortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.applesample.SpringMoviePortal.Beans.Movies;
import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAO;
import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAOImpl;


@SpringBootApplication
public class SpringMoviePortalApplication {

	@Autowired
	MoviesDatabaseDAO repository;
	//@Autowired
	//Movies movieObj;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMoviePortalApplication.class, args);
		
		
	    
	}
}
