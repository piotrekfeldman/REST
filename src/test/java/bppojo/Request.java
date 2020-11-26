package bppojo;

import files.ReusableMethods;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Request {

    public static void main (String [] args){

    baseURI = "http://216.10.245.166";
     Response rr =  given().queryParams("place_id","7c2f1e256863d5e1ff3babcfb3f26f88").
             queryParams("key","qaclick123").when()
             .get("/maps/api/place/get/json").then().statusCode(200).extract().response();
MainResponse bq = given().queryParams("place_id","7c2f1e256863d5e1ff3babcfb3f26f88").
        queryParams("key","qaclick123").expect().defaultParser(Parser.JSON).when()
        .get("/maps/api/place/get/json").as(MainResponse.class);




        JsonPath js=ReusableMethods.rawToJson(rr);
        System.out.println(js.get("location.latitude"));
        System.out.println(js.get("location.size"));

        String size = js.get("[0].length");



        System.out.println(size);








        // when().get("http://216.10.245.166/maps/api/place/get/json?place_id=7c2f1e256863d5e1ff3babcfb3f26f88&key=qaclick123").as(BliskaReq.class);
       // System.out.println(bq.getName());





    }
}
