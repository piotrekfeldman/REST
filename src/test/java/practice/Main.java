package practice;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class Main {

    public static void main (String [] args){

        JsonPath js= new JsonPath(PayLoad.DummyPayload());
        String title = js.get("courses[0].title");
        System.out.println("Title is : " + title);
        int count = js.get("courses.size");
        int prices = 0;
        int sumPrices = 0;
        int copies = 0;
        int sumCopies = 0;

        String str = "Chuj@Dupa";
        String st []  = str.split("@");
        System.out.println(st[0]);

        for(int i = 0; i<count ; i++){
            System.out.println(js.get("courses["+i+"].title"));

            prices = js.getInt("courses["+i+"].price");
            copies = js.getInt("courses["+i+"].copies");

            sumCopies =  sumCopies + (prices * copies);
        }

        int sum = sumCopies * sumPrices ;
        System.out.println(sumCopies);


        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase amount :"+purchaseAmount+ "; wynik mnożenia : "+ sumCopies);
        Assert.assertEquals(sumCopies, purchaseAmount);
    }
}
