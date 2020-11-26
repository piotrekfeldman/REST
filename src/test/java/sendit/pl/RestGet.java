package sendit.pl;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static org.hamcrest.Matchers.equalTo;

public class RestGet {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.param("location", "-33.8670522,151.1957362");
        httpRequest.param("radius", "1500");
        httpRequest.param("type", "restaurant");
        httpRequest.param("keyword", "cruise");
        httpRequest.param("key", "AIzaSyAK-2XhKA3NjuAnYfFKSYmQxi4wRcitUKQ");
        Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/json");
        String body = response.getBody().asString();
      //  body("results[0].id", equalTo("8e980ad0c819c33cdb1cea31e72d654ca61a7065"));
//                Assert.assertTrue(body);
        System.out.println("Reponse body : " + body);

        int statcode=response.getStatusCode();
        System.out.println("Status code : " + statcode);
        Assert.assertEquals(statcode, 200);


        Assert.assertEquals("","");


    }

}
