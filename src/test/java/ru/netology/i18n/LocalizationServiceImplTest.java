package ru.netology.i18n;

import ru.netology.entity.Country;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService;
    Country country;

    @BeforeEach
    void beforeEach() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void test_localeRussia() {
        country = Country.RUSSIA;
        String expectedMessage = "Добро пожаловать";

        Assertions.assertEquals(expectedMessage, localizationService.locale(country));
    }

    @Test
    void test_localeUSA() {
        country = Country.USA;
        String expectedMessage = "Welcome";

        Assertions.assertEquals(expectedMessage, localizationService.locale(country));
    }

    @Test
    void test_localeBrazil() {
        country = Country.BRAZIL;
        String expectedMessage = "Welcome";

        Assertions.assertEquals(expectedMessage, localizationService.locale(country));
    }
}