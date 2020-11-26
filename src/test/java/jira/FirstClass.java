package jira;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import files.ReusableMethods.*;
import files.ReusableMethods;

import static io.restassured.RestAssured.*;

public class FirstClass {

    @Test
    public void Update(){


        FirstClass fs=new FirstClass();


        RestAssured.baseURI = "http://localhost:8080";
        given().header("Content-Type","application/json").
                header("Cookie","JSESSIONID="+ReusableMethods.GetSessionKey()).
                body("{\n" +
                        "    \"body\": \"Marta Hara\"\n" +
                        "    \n" +
                        "}").when().
                put("/rest/api/2/issue/RES-3/comment/"+fs.ID()).
                then().statusCode(200);

    }


    public  String ID(){

        RestAssured.baseURI = "http://localhost:8080";

       Response res= given().header("Content-Type","application/json").
               header("Cookie","JSESSIONID="+ReusableMethods.GetSessionKey()).
                body("{\n" +
                        "    \"body\": \"Ożesz kurwa.\"\n" +
                        "   \n" +
                        "}").when().
                post("/rest/api/2/issue/RES-3/comment").then().
                assertThat().statusCode(201).extract().response();

                JsonPath js=ReusableMethods.rawToJson(res);
                String id=js.get("id");
        System.out.println("id to "+id);

        return id;
    }
}
