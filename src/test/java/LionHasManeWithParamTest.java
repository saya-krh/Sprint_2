package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class LionHasManeWithParamTest {


    String sex;
    boolean hasMane;

    public LionHasManeWithParamTest(String sex, Boolean hasMane){
        this.sex=sex;
        this.hasMane=hasMane;

    }

    @Parameterized.Parameters
    public static Object[][] getHasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    /**
     * Проверяем гриву.
     */
    @Test
    public void shouldMaleLionHasMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(lion.doesHaveMane(), hasMane);
    }

}