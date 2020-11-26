package kolekcje;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TotoLotek {
    public static void main(String [] args)
    {
        Set<Integer> lotek=new HashSet<>();
        Random r=new Random();

        while (lotek.size()<16){
            int i=r.nextInt(36)+1;
            System.out.println("wylosowano "+"\n"+i);
            lotek.add(i);
        }

        System.out.println(lotek);


    }
}
