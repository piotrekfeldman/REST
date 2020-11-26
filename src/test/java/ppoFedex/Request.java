package ppoFedex;

import bppojo.Utils;
import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Request {

public static FileInputStream fs;

    static {
        try {
            fs = new FileInputStream("C:\\Users\\piotr\\rest.project\\src\\test\\java\\ppoFedex\\data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Properties pr = new Properties();


    public static void main (String [] args) throws IOException {

        RequestSpecification reqSpec;
        pr.load(fs);
        String waybillNumber = pr.getProperty("waybillNumber");
        String weight = pr.getProperty("waybillNumber");

        RestAssured.baseURI = "http://ppo-operator-api.bliskapaczka.test";

        given().header("Authorization", "Bearer"+"a9f03900-b549-4186-9dbc-cfea0f29f3f6").
                header("content-Type","application/vnd.ppo-operator-api.v1+json").log().all().
                body(CreateShipment.payLoad(waybillNumber,10.0,10,10,10,"2020-06-28")).
                when().put("/api/shipments").then().assertThat().statusCode(200);






        GetShipmentPojo getship = given().header("Authorization", "Bearer"+"a9f03900-b549-4186-9dbc-cfea0f29f3f6")
                .log().all().
                when().get("/api/shipments/3336").then().
                assertThat().statusCode(200).extract().response().as(GetShipmentPojo.class);

        System.out.println(getship.getPointId()+getship.getBrand()+getship.getWaybillNumber());






    }
}
