package kolekcje;

import java.util.Map;

public class HashMap {

    public static void main(String[] args){
        Map<Integer, String> mapa= new java.util.HashMap<>();

        mapa.put(1, "Marta");
        mapa.put(2, "Piotr");
        mapa.put(1, "Ksadojf");

        for(Map.Entry<Integer, String> m: mapa.entrySet()){

            int key=m.getKey();
            String value=m.getValue();

            System.out.println(key+" " +value);
        }
        System.out.println(mapa.keySet()) ;
        System.out.println(mapa.values());

        System.out.println(mapa.containsKey(3));
    }
}
