package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import org.junit.rules.ExpectedException;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(value = 1)
    public Boolean hasMane;
    @Parameterized.Parameter(value = 2)
    public boolean exception;

    @Parameterized.Parameters(name = "{index}: sex - {0}, hasMane - {1}, exception - {2}")
    public static Object[][] data() {
        return new Object[][]{
                new Object[] {"Самец", true, true},
                new Object[] {"Самка", false, true},
                new Object[] {"Оно", null, false}
        };
    }

    @Test
    public void lionShouldGetFood() {
        try {
            String animalKind = "Хищник";
            Lion lion = new Lion(sex, feline);
            List<String> food = List.of("Еда");
//            List<String> food = List.of(null);
            when(feline.getFood(animalKind)).thenReturn(food);
            assertEquals(food, lion.getFood());
        } catch (Exception ex) {
//            if (exception) {
//                fail();
//            }
        }
    }

    @Test
    public void lionShouldHaveKittens() {
        try {
            Lion lion = new Lion(sex, feline);
            when(feline.getKittens()).thenReturn(1);
            assertEquals(1, lion.getKittens());
        } catch (Exception ex) {
            if (exception) {
                fail();
            }
        }
    }
    @Rule
    public ExpectedException exceptionMessage = ExpectedException.none();

    @Test
    public void lionDoesHaveMane() throws Exception {
        exceptionMessage.expect(Exception.class);
        exceptionMessage.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("Мужчина", new Feline());
        lion.doesHaveMane();

    }

}
