package sendit.pl;

import files.ReusableMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sendit.pl.E2EXml;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddBook2 {

    @Test
    public void Adding() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";

        Response r=given().log().all().
                body(E2EXml. GenerateStringFromResource("C:\\Users\\piotr\\rest.project\\src\\test\\java\\files\\book.json")).
                when().
                post("/Library/Addbook.php").
                then().log().all().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("Msg",equalTo("successfully added")).and().extract().response();

        JsonPath js= ReusableMethods.rawToJson(r);

        String t=js.get().toString();
        System.out.println(t);

    }
}
