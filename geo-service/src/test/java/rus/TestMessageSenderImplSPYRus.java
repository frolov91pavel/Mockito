package rus;

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

public class TestMessageSenderImplSPYRus {

    @Before
    public void before() {
        System.out.println("Начало тестироания");
    }

    @After
    public void after() {
        System.out.println("\nОкончание теста");
    }

    @Test
    public void testMessageSenderImplRus() {

        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl localizationServiceImpl = Mockito.spy(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationServiceImpl);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String result = messageSender.send(headers);

        Assertions.assertEquals("Добро пожаловать", result);

    }

}