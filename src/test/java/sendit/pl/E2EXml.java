package sendit.pl;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E2EXml {

    //ten skrypt sie nie wykona , ponieważ brakuje body xml

    public static void main(String[] args) throws IOException {

        Properties prop= new Properties();
        FileInputStream fs= new FileInputStream("C:\\Users\\piotr\\rest.project\\src\\test\\java\\files\\data.properties");
        prop.load(fs);

        RestAssured.baseURI=prop.getProperty("URI");

        String path=GenerateStringFromResource("C:\\Users\\piotr\\rest.project\\src\\test\\java\\files\\data.xml");
        Response res=given().
                queryParam("key",prop.getProperty("KEY")).
                body(path).when().
                post("/maps/api/place/add/xml").
                then().assertThat().statusCode(200).and().contentType(ContentType.XML).and().
                body("status",equalTo("OK")).extract().response();
        String resp=res.asString();

        XmlPath x=new XmlPath(resp);
        x.get("Parent.child");


    }

    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));

    }
}
