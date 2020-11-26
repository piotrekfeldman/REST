package liczbyLosowe;

import java.util.Random;

public class GenerowanieHasłaTymczasowego {


    public static void main(String[] arg)
    {
        Random r= new Random();
        String str="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        System.out.println("indeks 0 : "+str.charAt(0));
        int length= str.length();
        System.out.println(length);

        String kod="";

        for (int i=0; i<12; i++)
        {
           int pos= r.nextInt(length);
           kod= kod+str.charAt(pos);
        }
        System.out.println("Hasło tymczasowe to: "+kod);
        System.out.println("Hasło ma znaków: " + kod.length());

    }
}
