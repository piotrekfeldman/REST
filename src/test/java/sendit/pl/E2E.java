package sendit.pl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import files.payLoad;
import org.apache.poi.hpsf.Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import files.ReusableMethods;

import static files.ReusableMethods.rawToJson;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class E2E {

    public static void main(String[] args) throws IOException {

        Properties prop= new Properties();
        FileInputStream fs= new FileInputStream("C:\\Users\\piotr\\rest.project\\src\\test\\java\\files\\data.properties");
        prop.load(fs);

        RestAssured.baseURI=prop.getProperty("URI");
        Response res=given().log().all().
                queryParam("key",prop.getProperty("KEY")).
                body(payLoad.Data()).when().
                post("/maps/api/place/add/json").
                then().log().all().and().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK")).extract().response();
        String resp=res.asString();
        JsonPath js=ReusableMethods.rawToJson(res);

        //JsonPath js=new JsonPath(resp);
        String placeid=js.get("place_id");
        System.out.println(placeid);

        System.out.println(resp);

        given().
                queryParam("key","qaclick123").
                body("{\n"+
                        "\"place_id\":\""+placeid+"\""+
        "}\n").when().
                post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().body("status",equalTo("OK"));

        String boddy=get().body().asString();
        System.out.println(boddy);
    }
}
