package liczbyLosowe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import liczbyLosowe.homeLoan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Losowe {

    homeLoan hl = new homeLoan();


    public static void main(String[] arg) {

        Random r = new Random();

        int a = r.nextInt();
        System.out.println(a);

        int b = r.nextInt(4) + 1;
        System.out.println("od zera: " + b);

        int c = r.nextInt(10) + 1;
        System.out.println(c);

        float e = r.nextFloat();
        System.out.println(e);

        double f = r.nextDouble();
        System.out.println(f);

        boolean g = r.nextBoolean();
        System.out.println(g);

        List<Integer> lol = new ArrayList<>();
        lol.add(5);
        lol.add(10);
        lol.add(15);


        int[][] tablica = {{1, 2}, {3, 5}};

        String[][] strArray = new String[tablica.length][tablica.length];

        for (int i = 0; i < tablica.length; i++) {
            strArray[i][i] = String.valueOf(tablica[i][i]);

            System.out.println(Arrays.toString(strArray));
        }


    }


    @Test(dataProvider = "getData")
    public void DataProviding(String log, String pass) {

        System.out.println("homeLoanLogginForm");
        System.out.println(log);
        System.out.println(pass);

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "1user";
        data[0][1] = "1pass";
        data[1][0] = "2user";
        data[1][1] = "2pass";
        data[2][0] = "3user";
        data[2][1] = "3pass";
        return data;


    }

    @Test(dataProvider = "getData2")
    public void DataProviding(int log, int pass, String tekst) {

        System.out.println("homeLoanLogginForm");
        System.out.println(log);
        System.out.println(pass);
        System.out.println(tekst);

    }

    @DataProvider
    public Object[][] boundaryValues() {
        Object[][] data = {{1, 2, "fiut"}, {3, 4, "kutas"}, {7, 9,"chuj"}};

        return data;
    }
}