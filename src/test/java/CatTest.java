package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class CatTest {

    @Mock
    Feline feline;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void catShouldHaveFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> list = List.of("Test");
        when(feline.eatMeat()).thenReturn(list);
        assertEquals(list, cat.getFood());

    }


    @Test
    public void catShouldHaveSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
}