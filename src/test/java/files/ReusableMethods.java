package files;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class ReusableMethods {

    public static RequestSpecification rq;

    public RequestSpecification RequestSpec () throws FileNotFoundException {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        if (rq == null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
            rq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log)).
                            addFilter(ResponseLoggingFilter.logResponseTo(log)).
                            setContentType(ContentType.JSON).build();
            return rq;
        }
        return rq;
    }


    public static XmlPath rawToXM(Response r)
    {
        String resp=r.asString();

        XmlPath x=new XmlPath(resp);
        return x;

    }

    public static JsonPath rawToJson(Response r)
    {
        String resp=r.asString();

        JsonPath x=new JsonPath(resp);
        return x;

    }
    @Test
    public static String GetSessionKey()
    {
        RestAssured.baseURI = "http://localhost:8080";

        Response res=given().header("Content-Type","application/json").body("{ \"username\": \"admin\", \"password\": \"System11\" }").when().
                post("/rest/auth/1/session").then().statusCode(200).extract().response();

       // String resp=res.asString();

        JsonPath x=ReusableMethods.rawToJson(res);
       String b= x.get("session.value");
        System.out.println(b);
        return b;

    }

}
