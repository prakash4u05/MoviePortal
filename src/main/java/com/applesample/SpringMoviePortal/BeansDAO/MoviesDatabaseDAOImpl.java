package com.applesample.SpringMoviePortal.BeansDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.applesample.SpringMoviePortal.Beans.Movies;
import com.applesample.SpringMoviePortal.Beans.Users;

@Repository
public class MoviesDatabaseDAOImpl implements MoviesDatabaseDAO {
	
	 //@Autowired
	 Movies movieObj=new Movies();
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	
	@Override
	public List<String> getMovieTitles()
	{
		List<String> movieName = new ArrayList<String>();
		movieName.add("Matrix");
		movieName.add("Croods");
		movieName.add("My name is Khan");
		movieName.add("Baby");
		
		return movieName;
		
		
	}
	@Override
	public Movies getMovieInfo(String mNAme)
	{
		String getquery="select * from  moviedata where MOVIENAME='"+mNAme+"'";  
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(getquery);
		System.out.println("Mname"+getquery);
		for (Map row : rows) {
		movieObj.setMovieTitle((String)row.get("MOVIENAME"));
		movieObj.setMoviePrice((Integer)row.get("MOVIEPRICE"));
		//movieObj.setDateIssued(java.time.LocalDate.parse(row.get("DATEISSUED").toString()));
		}
		System.out.println("New"+movieObj);
		return movieObj;
	}
	
	@Override
	public List<Movies> getAllMoviesInfo()
	{
		List<Movies> MoviesList =  new ArrayList<Movies>();
		//MoviesList.add(new Movies("Matrix",60,LocalDate.of(2017, Month.DECEMBER, 10),LocalDate.of(2017, Month.DECEMBER, 17)));
		//MoviesList.add(new Movies("Croods",70,LocalDate.of(2017, Month.DECEMBER, 13),LocalDate.of(2017, Month.DECEMBER, 20)));
		//MoviesList.add(new Movies("My name is Khan",80,LocalDate.of(2017, Month.DECEMBER, 12),LocalDate.of(2017, Month.DECEMBER, 19)));
		//MoviesList.add(new Movies("Baby",100,LocalDate.of(2017, Month.DECEMBER, 11),LocalDate.of(2017, Month.DECEMBER, 18)));
		//jdbcTemplate.execute("insert into testtable values('ok')");
		String query="select * from moviedata";
      System.out.println("query"+query+"connection"+jdbcTemplate);
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
		System.out.println("row object"+rows);
		for (Map row : rows) {
			System.out.println("inside for"+row);
			Movies movie = new Movies();
			movie.setMovieTitle((String)row.get("MOVIENAME"));
			movie.setMoviePrice((Integer)row.get("MOVIEPRICE"));
			//movie.setDateIssued(java.time.LocalDate.parse(row.get("DATEISSUED").toString()));
	
			System.out.println("Movie Object"+movie);
			MoviesList.add(movie);
			
		}
		return MoviesList;
	}
	@Override
	public List<Movies> getmoviesList()
	{
		System.out.println("pkp");
		List<Movies> MoviesList =  new ArrayList<Movies>();
		String query="select * from moviedata";
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
		System.out.println("row object"+rows);
		for (Map row : rows) {
			System.out.println("inside for"+row);
			Movies movie = new Movies();
			movie.setMovieTitle((String)row.get("MOVIENAME"));
			movie.setMoviePrice((Integer)row.get("MOVIEPRICE"));
			//movie.setDateIssued(java.time.LocalDate.parse(row.get("DATEISSUED").toString()));
	
			System.out.println("Movie Object"+movie);
			MoviesList.add(movie);
			
		}
		return MoviesList;
	}
	
	
	/*Dummmy method for inserting to DB*/
	@Override
	public boolean insertmoviedata(Movies mObj)
	{
		LocalDate ld=LocalDate.of(2017, Month.DECEMBER, 11);
	    String query="insert into moviedata values(?,?,?)";  
	    jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	              
	        ps.setString(1,"My name is Khan");  	
	        ps.setInt(2, 80);
	        ps.setDate(3,Date.valueOf(ld));
	        return ps.execute();  
	              
	    }  
	    });  
		return true;
	}
	
	@Override
	public Users validateUser(String email,String pwd) {
			    String sql = "select * from USERINFO where useremail='" + email + "' and password='" + pwd
			    + "'";
			    List<Users> users = jdbcTemplate.query(sql, new UserMapper());
			    return users.size() > 0 ? users.get(0) : null;
			    }
	
	@Override
	public Users getUserdetails(String username) {
		
		Users user = new Users();
		 String sql1 = "select * from USERDETAILS where username='" + username +  "'";
		 List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql1);
			for (Map row : rows) {
				user.setFirstName((String)row.get("FIRSTNAME"));
				user.setLastName((String)row.get("LASTNAME"));
				user.setCardNumber((String)row.get("CREDITCARD"));
				user.setEmailAddr((String)row.get("EMAILID"));
				user.setRegistrationStatus(true);
			//movieObj.setDateIssued(java.time.LocalDate.parse(row.get("DATEISSUED").toString()));
			}
			System.out.println("New"+movieObj);
				    return user;
	}
	@Override
	public boolean insertmovieinUserdata(String moviename, String username) {
		// TODO Auto-generated method stub
		LocalDate ld=LocalDate.now();
	    String query="insert into USERMOVIES values(?,?,?)";  
	    jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	              
	        ps.setString(1,moviename);  	
	        ps.setString(2, username);
	        ps.setDate(3,Date.valueOf(ld));
	        return ps.execute();  
	              
	    }  
	    });  
		return true;
	}
	@Override
	public List<Movies> getmoviesOptionsList(String Moviename) {
		
		List<Movies> MoviesListOptions =  new ArrayList<Movies>();
		String query="select * from moviedata where movietype='"+Moviename+"'";
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
		System.out.println("row object"+rows);
		for (Map row : rows) {
			//System.out.println("inside for"+row);
			Movies movie = new Movies();
			movie.setMovieTitle((String)row.get("MOVIENAME"));
			movie.setMoviePrice((Integer)row.get("MOVIEPRICE"));
			//movie.setDateIssued(java.time.LocalDate.parse(row.get("DATEISSUED").toString()));
	
			System.out.println("Movie Object"+movie);
			MoviesListOptions.add(movie);
			
		}
		return MoviesListOptions;
	}
	}
class UserMapper implements RowMapper<Users> {
	  public Users mapRow(ResultSet rs, int arg1) throws SQLException {
	    Users user = new Users();
	    user.setFirstName(rs.getString("username"));
//	    user.set(rs.getString("password"));
//	    user.setFirstname(rs.getString("firstname"));
//	    user.setLastname(rs.getString("lastname"));
//	    user.setEmail(rs.getString("email"));
//	    user.setAddress(rs.getString("address"));
//	    user.setPhone(rs.getInt("phone"));
	    return user;
	  }

}
