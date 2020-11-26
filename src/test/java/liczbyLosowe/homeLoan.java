package liczbyLosowe;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class homeLoan {


    @Parameters({"URL"})
    @Test
    public void homeLoanLogginForm(String urlname) {

        System.out.println("homeLoanLogginForm");
        System.out.println(urlname);
    }

    @BeforeClass
    public void Klass() {

        System.out.println("Przed klasą HOME");


    }
    @Parameters({"URL"})
    @Test(timeOut = 4000)
    public void homeLoanRegisterForm(String urlname) {

        System.out.println("homeLoanRegisterForm");
        System.out.println(urlname);

    }

    @Test(dataProvider = "getData")
    public void DataProviding(String log, String pass) {

        System.out.println("homeLoanLogginForm");
        System.out.println(log);
        System.out.println(pass);

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][]data=new Object[3][2];
        data[0][0]="1user";
        data[0][1]="1pass";
        data[1][0]="2user";
        data[1][1]="2pass";
        data[2][0]="3user";
        data[2][1]="3pass";
        return data;

    }
}
