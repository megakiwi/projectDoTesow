package pl.testy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("pierwsza klasa testowa")
public class FirstClass {

    @BeforeEach
    public void beforeEach(){
        System.out.println(" :) ");
    }

    @Test
    @DisplayName("pierwsza metoda testowa")
    public void metoda1(){
       assertTrue(1==1);
//
    }

/*
    @Test
    public void metoda2(){
        String str = "superString";
        assertEquals("superString", str);
    }

    @Test
    public void metoda3(){
        String str = "superString";
        assertThat(str, equalTo(str));
        assertThat(str, endsWith("String"));
    }

    @Test
    public void metoda4(){
        String str = "superString";
        assertAll( () ->{
            assertThat("superString", equalTo(str));
            assertThat("superString", endsWith("String"));
        });
    }*/
}
