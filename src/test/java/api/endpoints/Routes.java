package api.endpoints;

/*
 Create user(post) : https://petstore.swagger.io/v2/user
                     ----------base URL------------
 Get user(Get) : https://petstore.swagger.io/v2/user/{username}
                                               ----end points----
 Update user(put) : https://petstore.swagger.io/v2/user/{username}
 Delete user(delete) : https://petstore.swagger.io/v2/user/{username}
 */

public class Routes 
{
public static String base_url="https://petstore.swagger.io/v2";

//roots of user model(end points)

public static String post_url=base_url+"/user";
public static String get_url=base_url+"/user/{username}";
public static String update_url=base_url+"/user/{username}";
public static String delete_url=base_url+"/user/{username}";

//store module
//here you will create store module URL's
//pet module
//here you will create pet module URL's  



}
