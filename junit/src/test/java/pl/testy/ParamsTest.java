package pl.testy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("testy parametryzowalne")
public class ParamsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 8, 3})
    public void metoda1(int number) {
        assertTrue(number < 10);
//
    }

    @ParameterizedTest
    @ValueSource(strings = {"hellod", "world"})
    public void metoda2(String str) {
        assertTrue(str.endsWith("d"));
//
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"Hello, 1", "Hworld, 2", "'Hhahaha,haha', 43"})
    public void testmetoda3Test(String param1, int param2) {
        assertTrue(param1.startsWith("H"));
        assertTrue(param2 < 44);
//
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/plikZDanymi.csv", delimiter = ',')
    public void metoda4(String param1, int param2) {
        assertTrue(param1.startsWith("H"));
        assertTrue(param2 < 44);
//
    }

    @Test
    public void metoda5Exc() {
        assertThrows(IllegalArgumentException.class,
                () -> GamePlay.play(0));
    }
}
