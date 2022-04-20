package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    /**
     * Лев неизвестного пола должен выдать ошибку.
     */
    @Test(expected = Exception.class)
    public void shouldLionWithIncorrectSexHasError() throws Exception {
        new Lion("Киборг ", new Feline());
    }

    /**
     * Список еды у льва должен быть заполнен.
     */
    @Test
    public void shouldLionHasFood() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(feline.getFood("Хищник"),lion.getFood());
    }

    /**
     * У льва должны быть котята
     */
    @Test
    public void lionShouldHaveKittens() throws Exception {
        Assert.assertEquals(new Lion("Самец", new Feline()).getKittens(),1);
    }


}
