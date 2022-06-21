package locationTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class LocaleTest {

    @Before
    public void before() {
        System.out.println("Начало тестироания");
    }

    @After
    public void after() {
        System.out.println("\nОкончание теста");
    }

    @Test
    public void localTest() {

        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        String city = location.getCity();

        Assertions.assertEquals(city, "Moscow");

    }
}
