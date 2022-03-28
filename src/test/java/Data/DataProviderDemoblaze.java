package Data;

import org.testng.annotations.DataProvider;

public class DataProviderDemoblaze {
    @DataProvider(name = "toCompleteForm")
    public static Object[][] getUsers() {
        return new Object[][]
                {
                        {"Paula", "Alaska", "Palmer", "42857541924", "07", "27"},
                        {"Gisella", "Argentina", "Cordoba", "685990045889874", "04", "23"}
                };
    }
}