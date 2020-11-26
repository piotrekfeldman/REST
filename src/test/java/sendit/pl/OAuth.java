package sendit.pl;
import files.payLoad;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojo.Api;
import pojo.GetCourses;
import pojo.WebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class OAuth {

    public static void main(String [] args)
    {

        /*rozpisujemy kod w selenium webdriver, tak aby w pierwszej
        kolejności otrzymac authorization kod
        W tym celu należy najpierw podac dane autoryzacyjne np w googlu
        a potem wyciągnać kod autoryzacyjny z otrzymanego urla
        */

        //String url= driver.getCurrentUrl();  << ta linijka kodu pobierze url, potem należy podzielić url i wyciągnać interesujące nas wartości
        //String partial =url.split("code=")[1];
        // String code=partial.split("&scope")[0];


        // url encodingenabled false - w celu zablokowania możliwości rozkodowywania znaków specjalnych tj %
        // czyli jeżeli pojawi się znak "%" to rest assured przekonwertuje go jeżeli nie będize ustawionego
        // urlencodingenabled(false).
       String tokenResponse=given().urlEncodingEnabled(false).
             //   queryParams("code",/*code*/).
                queryParams("client_id","009809320398").
                queryParams("client_secret","0tue09u").
                queryParams("redirect_Url","").
                when().
                post("http://googleapis.com/oauth/v4/token").asString();

        JsonPath x=new JsonPath(tokenResponse);
        String accessToken=x.getString("access_token");

        //default parsera używamy do tego abyo określić w jakim formacie oczekujemy odpowiedzi zwrotnej
        // jeżei ma to być json to wtedy parser.json

        GetCourses gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).
                when().
                get("https://rahulacademy.com/getCourse.php").as(GetCourses.class);

        System.out.println(gc.getServices());
        gc.getCourses().getApi().get(1).getCourseTitle();

        String [] courses= {"Course1","Course2", "Course3" };
        List<Api> apiCor=gc.getCourses().getApi();

        for(int i=0;i<apiCor.size();i++)

        {
            if(apiCor.get(i).getCourseTitle().equalsIgnoreCase("SoapUI WebServices"))
            {
                System.out.println(apiCor.get(i).getPrice());
            }
        }

        List<WebAutomation> webAuto=gc.getCourses().getWebAutomation();
        ArrayList<String> actual=new ArrayList<>();
        for (int j=0;j<webAuto.size();j++)
        {
            actual.add(webAuto.get(j).getCourseTitle());
        }

        List<String> expected=Arrays.asList(courses);
        Assert.assertTrue(actual.equals(expected));



    }
}
