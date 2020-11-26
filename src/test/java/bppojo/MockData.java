package bppojo;

import java.net.URI;

public class MockData {

    public static String payLoad(){

        String body = "{\n" +
                "\t\"waybillNumber\": \"fgfgfdgdf2312346578901\",\n" +
                "\t\"pointId\": \"077158\",\n" +
                "\t\"brand\": \"KOLPORTER\",\n" +
                "\t\"expectedDelivery\": \"2020-03-24\",\n" +
                "\t\"parcels\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"waybillNumber\": \"fgfgfdgdf231214376801\",\n" +
                "\t\t\t\"length\": 20,\n" +
                "\t\t\t\"width\": 20,\n" +
                "\t\t\t\"height\": 20,\n" +
                "\t\t\t\"weight\": 5.158\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"additionalServices\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"serviceType\": \"COD\",\n" +
                "\t\t\t\"amount\": 30.41\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"serviceType\": \"INSURANCE\",\n" +
                "\t\t\t\"amount\": 123.41\n" +
                "\t\t}\n" +
                "\t]\n";

        return body;

    }
}
