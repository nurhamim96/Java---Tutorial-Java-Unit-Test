package com.tutorial.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock() {

        // Membuat Mock Object
        List<String> list = Mockito.mock(List.class);

        // Menambahkan Behaviour ke Mock Object
        Mockito.when(list.get(0)).thenReturn("Ibad");
        Mockito.when(list.get(100)).thenReturn("Nurhamim");

        // Test Mock
        Assertions.assertEquals("Ibad", list.get(0));
        Assertions.assertEquals("Nurhamim", list.get(100));

        // Verify Mock
        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}

/*
* NOTE :
* keuntungan kita membuat object tiruan/mock kita bisa menambahkan behavior apapun yang kita mau kepada object tersebut;
* */