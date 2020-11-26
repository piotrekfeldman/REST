package ppoFedex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Serialization {

    public static GetShipmentPojo SeriaLoad(){

        ParcelsPojo pj = new ParcelsPojo();

        GetShipmentPojo g = new GetShipmentPojo();
      //  g.setAdditionalServices("");
        g.setBrand("KOLPORTER");
      //  g.setCreated();
        g.setExpectedDelivery("2020-06-28");
      //  g.setParcels();
        g.setPointId("001920");
      //  g.setStatus();
      //  g.setType();
        g.setWaybillNumber("4444");


        pj.setHeight(15);
        pj.setLength(15);
        pj.setWaybillNumber("4444");
        pj.setWeight(10.0);
        pj.setWidth(10);
        List<ParcelsPojo> myList= new ArrayList<>();
        myList.addAll((Collection<? extends ParcelsPojo>) pj);

        g.setParcels(myList);

        return g;

    }
}
