package kolekcje;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetInterfejs {
    public static void main(String [] args)
    {
        Set<Object>setStr=new HashSet<>();
        setStr.add("Jeden");
        setStr.add("Dwa");
        setStr.add("Trzy");
        setStr.add("One");
        setStr.add("1");
        setStr.add("2");
        setStr.add("2");

        for(Object t:setStr)
        {
            System.out.println(t);
        }

        System.out.println("*****************");
        List<Object> tt = new ArrayList<>();
        tt.add(1);
        tt.add(3);
        tt.add(2);
        tt.add(2);
        tt.add(2);

        tt.add("jeden");

        for(Object t:tt){
            System.out.println(t);
        }


    }
}
