package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {

    GeoServiceImpl geoService;

    @BeforeEach
    void beforeEach() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void test_byIpRussian1() {
        Country expectedCountry = Country.RUSSIA;
        String testIP = "172.0.32.11";

        Assertions.assertEquals(expectedCountry, geoService.byIp(testIP).getCountry());
    }

    @Test
    void test_byIpRussian2() {
        Country expectedCountry = Country.RUSSIA;
        String testIP = "172.0.58.58";

        Assertions.assertEquals(expectedCountry, geoService.byIp(testIP).getCountry());
    }

    @Test
    void test_byIpUSA1() {
        Country expectedCountry = Country.USA;
        String testIP = "96.44.183.149";

        Assertions.assertEquals(expectedCountry, geoService.byIp(testIP).getCountry());
    }

    @Test
    void test_byIpUSA2() {
        Country expectedCountry = Country.USA;
        String testIP = "96.0.58.58";

        Assertions.assertEquals(expectedCountry, geoService.byIp(testIP).getCountry());
    }

    @Test
    void test_byIpLocalHost() {
        String testIP = "127.0.0.1";

        Assertions.assertNull(geoService.byIp(testIP).getCountry());
    }

    @Test
    void test_byIpAnotherIP_NullExpected() {
        String testIP = "175.0.0.1";

        Assertions.assertNull(geoService.byIp(testIP));
    }
}
