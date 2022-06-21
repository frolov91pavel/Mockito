package eng;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class TestMessageSenderImplSPYEng {

    @Before
    public void before() {
        System.out.println("Начало тестироания");
    }

    @After
    public void after() {
        System.out.println("\nОкончание теста");
    }

    @Test
    public void testMessageSenderImplEng() {

        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationServiceImpl localizationServiceImpl = Mockito.spy(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationServiceImpl);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String result = messageSender.send(headers);

        Assertions.assertEquals("Welcome", result);

    }

}