package ppoFedex;

public class CreateShipment {

    public static String payLoad(String waybillNumber, double weight, int length, int height, int width,
                                 String expectedDelivery ){

        String body = "{\n" +
                "\t\"brand\": \"KOLPORTER\",\n" +
                "\t\"parcels\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"waybillNumber\": \""+waybillNumber+"\",\n" +
                "\t\t\t\"weight\":"+weight+",\n" +
                "\t\t\t\"length\":"+length+",\n" +
                "\t\t\t\"height\":"+height+",\n" +
                "\t\t\t\"width\":"+width+"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"additionalServices\": [],\n" +
                "\t\"expectedDelivery\": \""+expectedDelivery+"\",\n" +
                "\t\"waybillNumber\": \""+waybillNumber+"\",\n" +
                "\t\"pointId\": \"001920\"\n" +
                "}";

        return body;
    }

    public static String payLoad2(){

        String body = "{\n" +
                "\t\"brand\": \"KOLPORTER\",\n" +
                "\t\"parcels\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"waybillNumber\": \"3335\",\n" +
                "\t\t\t\"weight\": 10.0,\n" +
                "\t\t\t\"length\": 10,\n" +
                "\t\t\t\"height\": 10,\n" +
                "\t\t\t\"width\": 10\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"additionalServices\": [],\n" +
                "\t\"expectedDelivery\": \"2020-06-28\",\n" +
                "\t\"waybillNumber\": \"3335\",\n" +
                "\t\"pointId\": \"001920\"\n" +
                "}";

        return body;
    }

}
