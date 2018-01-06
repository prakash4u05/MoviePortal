package com.applesample.SpringMoviePortal.BeansDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.applesample.SpringMoviePortal.Beans.Movies;
import com.applesample.SpringMoviePortal.Beans.Users;

@Repository
public interface MoviesDatabaseDAO {
	
	public List<String> getMovieTitles();
	public List<Movies> getAllMoviesInfo();
	public Users validateUser(String useremail,String pwd);
	public Users getUserdetails(String username);
	public Movies getMovieInfo(String mName);
	public List<Movies> getmoviesList();
	public List<Movies> getmoviesOptionsList(String Moviename);
	public boolean insertmovieinUserdata(String moviename,String username);
	public boolean insertmoviedata(Movies mObj);
	
}
