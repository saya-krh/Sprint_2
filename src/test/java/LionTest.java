package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;;
import java.util.List;
import java.util.Collection;;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.rules.ExpectedException;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionShouldHaveKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionMale() throws Exception {
        Lion lion = new Lion ("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFemale() throws Exception {
        Lion lion = new Lion ("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionInvalidSex() throws Exception {
        Lion lion = new Lion ("Любой гендер", feline);
    }

    @Test
    public void lionFood() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List <String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());

    }



}
