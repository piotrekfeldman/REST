package sendit.pl;

import com.sun.org.apache.xpath.internal.operations.Equals;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import files.ReusableMethods.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://maps.googleapis.com";

        Response r=given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "1500").
                param("type", "restaurant").
                param("keyword", "cruise").
                param("key", "AIzaSyAK-2XhKA3NjuAnYfFKSYmQxi4wRcitUKQ").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].id",equalTo("8e980ad0c819c33cdb1cea31e72d654ca61a7065")).and().
                header("Content-Type","application/json; charset=UTF-8").extract().response();

        String body=get().body().asString();

        JsonPath js=ReusableMethods.rawToJson(r);

        System.out.println(r);

        int count=js.get("results.size()");
        System.out.println(count);

        for(int i=0; i<count;i++){

            System.out.println(js.get("results["+i+"].name"));

            System.out.println("Pierwszy rezultat to "+js.get("results[0].name"));
        }
    }

}


