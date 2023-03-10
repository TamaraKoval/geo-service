package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    MessageSenderImpl messageSender;
    Map<String, String> headers = new HashMap<>();

    GeoService geoService = Mockito.mock(GeoService.class);
    LocalizationService localizationService = Mockito.mock(LocalizationService.class);

    @BeforeEach
    void beforeEach() {
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void testSendRussian1() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        String expectedMessage = "Добро пожаловать";

        Mockito.when(geoService.byIp(Mockito.startsWith("172."))).thenReturn(location);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Assertions.assertEquals(expectedMessage, messageSender.send(headers));
    }

    @Test
    void testSendRussian2() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.58.58.58");

        Location location = new Location(null, Country.RUSSIA, null, 0);
        String expectedMessage = "Добро пожаловать";

        Mockito.when(geoService.byIp(Mockito.startsWith("172."))).thenReturn(location);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Assertions.assertEquals(expectedMessage, messageSender.send(headers));
    }

    @Test
    void testSendUSA1() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);;
        String expectedMessage = "Welcome";

        Mockito.when(geoService.byIp(Mockito.startsWith("96."))).thenReturn(location);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Assertions.assertEquals(expectedMessage, messageSender.send(headers));
    }

    @Test
    void testSendUSA2() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.58.58.58");

        Location location = new Location(null, Country.USA, null, 0);;
        String expectedMessage = "Welcome";

        Mockito.when(geoService.byIp(Mockito.startsWith("96."))).thenReturn(location);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Assertions.assertEquals(expectedMessage, messageSender.send(headers));
    }
}
