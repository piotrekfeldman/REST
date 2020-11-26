package kolekcje;

import java.util.ArrayList;
import java.util.List;

public class Array {

    public static void main(String [] args)
        {
        List<String> lista=new ArrayList<>();

        lista.add("Piotr");
        lista.add("Marta");

        for(String s:lista){
            System.out.println(lista);
        }
        lista.add(1, "sdfhiuidsa");

        for(String s:lista){
            System.out.println(s);
        }
    }
}
