package sendit.pl;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import files.payLoad.*;
import files.ReusableMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddBook {



    @Test(dataProvider = "Books")
    public void Adding(String t1, String t2)
    {
        RestAssured.baseURI = "http://216.10.245.166";

        Response r=given().log().all().
                body(payLoad.AddBook(t1,t2)).
                when().
                post("/Library/Addbook.php").
                then().log().all().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("Msg",equalTo("successfully added")).and().extract().response();

        JsonPath js=ReusableMethods.rawToJson(r);

        String t=js.get().toString();
        System.out.println(t);

    }
    @DataProvider(name="Books")
    public Object[][] getData()
    {
        return new Object[][] {{"owjty","9648"},{"iuyewie","6655"},{"sdasd","2121"}};

    }
}
