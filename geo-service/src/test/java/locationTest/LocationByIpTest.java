package locationTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class LocationByIpTest {

    @Before
    public void before() {
        System.out.println("Начало тестироания");
    }

    @After
    public void after() {
        System.out.println("\nОкончание теста");
    }

    @Test
    public void locationByIpTest() {

        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.11");

        Assertions.assertEquals(location.getCountry(), Country.RUSSIA);

    }

}
