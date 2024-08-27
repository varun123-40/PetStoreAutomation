package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests 
{
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
public void setupData()
{
	faker=new Faker();
	userPayload=new User();
	
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5,10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	//Logs
	logger=LogManager.getLogger(this.getClass());
	
}
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("*********Creating User**********");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************user is created*********");
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
	logger.info("*********Reading User info**********");
	Response response=UserEndPoints.readUser(this.userPayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("**************user info is displayed*********");
	}
	@Test(priority=3)
	public void testUdateUserByName()
	{
		logger.info("*********Updating User**********");
		//update using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 405);	
		//check the data after update
		Response responseAfterupdate=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 405);
		logger.info("*********User is updated**********");
	}
	@Test
	public void testDeleteUserByName()
	{
		logger.info("*********Deleting User**********");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 404);
		logger.info("*********User deleted**********");
	}
}
