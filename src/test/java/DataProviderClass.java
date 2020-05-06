import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "searchItems")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"водка"},
                {"коньяк"},
                {"вино"}
        };
    }
}
