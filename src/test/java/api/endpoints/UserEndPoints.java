package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User end points.java file
//created for perform create,read,update,delete request to the user API

public class UserEndPoints 
{

	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	
	public static Response readUser(String userName)
	{
		Response response=given()
		.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		return response;
	}
	public static Response updateUser(String userName, User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.post(Routes.update_url);
		return response;
	}
	public static Response deleteUser(String userName)
	{
		Response response=given()
		.pathParam("username", userName)
		.when()
		.delete(Routes.delete_url);
		return response;
	}
}
