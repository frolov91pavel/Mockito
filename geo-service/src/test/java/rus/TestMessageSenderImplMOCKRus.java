package rus;

import mock.GeoServiceImplMock;
import mock.LocalizationServiceImplMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Location;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class TestMessageSenderImplMOCKRus {

    @Before
    public void before() {
        System.out.println("Начало тестироания");
    }

    @After
    public void after() {
        System.out.println("\nОкончание теста");
    }

    @Test
    public void testMessageSenderImplMOCKRus() {

        GeoServiceImplMock geoService = new GeoServiceImplMock(true);
        Location location = geoService.byIp("");

        LocalizationServiceImplMock localizationService = new LocalizationServiceImplMock();
        String text = localizationService.locale(location.getCountry());

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "000.000.00.00");

        String result = messageSender.send(headers);

        Assertions.assertEquals(text, result);
    }

}
