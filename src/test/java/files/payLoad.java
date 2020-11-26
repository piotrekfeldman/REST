package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class payLoad {

    public static String Data()
    {

        String body="{\n" +
                "\n" +
                "    \"location\":{\n" +
                "\n" +
                "        \"lat\" : -38.383494,\n" +
                "\n" +
                "        \"lng\" : 33.427362\n" +
                "\n" +
                "    },\n" +
                "\n" +
                "    \"accuracy\":50,\n" +
                "\n" +
                "    \"name\":\"Frontline house\",\n" +
                "\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "\n" +
                "    \"language\" : \"French-IN\"\n" +
                "\n" +
                "}\n";

        return  body;
    }

    public static String AddBook(String isbn, String aisle){

        String book="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"bczdcock\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John Chuj\"\n" +
                "}";
        return book;
    }



}
