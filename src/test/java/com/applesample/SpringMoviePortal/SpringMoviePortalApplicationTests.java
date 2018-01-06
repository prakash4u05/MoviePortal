package com.applesample.SpringMoviePortal;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.applesample.SpringMoviePortal.BeansDAO.MoviesDatabaseDAO;
import com.applesample.SpringMoviePortal.Controller.MoviesRestController;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(MoviesRestController.class)
public class SpringMoviePortalApplicationTests {

	// @Autowired
	// private MockMvc mvc;
	 
	// @MockBean
	// private MoviesRestController movieController;
	
	@Test
	public void contextLoads() {
	}
//
//	@Test
//	public void MoviesCheck() {
//		//given(movieController.getAllMovieList());
//
//	}
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MoviesDatabaseDAO movieService;

//	Course mockCourse = new Course("Course1", "Spring", "10 Steps",
//			Arrays.asList("Learn Maven", "Import Project", "First Example",
//					"Second Example"));

	//String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void retrieveDetailsForMovies() throws Exception {

		//Mockito.when(
			//	movieService.getmoviesList().thenReturn("ok");//Mockito.anyString(),//http://localhost:8080

  
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/MoviesNames").accept(
				MediaType.APPLICATION_JSON);
		System.out.println("inside"+mockMvc);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
		System.out.println("ok"+result.getResponse());
		String expected = "{entity:[],status:200,metadata:{},annotations:null,genericType:null,postProcessInterceptors:null,messageBodyWriterInterceptors:null,resourceMethod:null,resourceClass:null}";
		System.out.println(result.getResponse()
				.getContentAsString());
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
	
	}
}
