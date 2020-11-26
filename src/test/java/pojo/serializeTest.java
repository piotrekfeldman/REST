package pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.ReusableMethods;
import io.restassured.specification.RequestSpecification;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class serializeTest {

    public static void main(String[] args)

    {
        AddPlace p=new AddPlace();

        p.setAccuracy(50);
        p.setAddress("Lotnicza 147");
        p.setLanguage("French-IN");
        p.setPhone_number("648916216");
        p.setWebsite("onet.pl");
        p.setName("costam");
        List<String> myList=new ArrayList<String>();
        myList.add("cpsds");
        myList.add("dsaa");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(50.3091283092);
        l.setLng(-32.901821);

        p.setLocation(l);


    RestAssured.baseURI="https://rahulshettyacademy.com";

        Response res=given().queryParam("key","qaclick123").
                body(p).when().post("/maps/api/place/add/json").
                then().statusCode(200).extract().response();

       String r= res.asString();
        System.out.println(r);
        JsonPath js=ReusableMethods.rawToJson(res);



    }
}
