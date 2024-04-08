package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void testGetReaderId(){
        Library library = new Library();
        Reader reader = new Reader(1, library);

        assertEquals(1,reader.getReaderId());
    }

    @Test
    void testReader()throws InterruptedException{
        Library library = new Library();
        Reader reader = new Reader(1, library);

        assertEquals(0,library.getReadersInside());
        reader.start();
        Thread.sleep(1000);
        assertEquals(1,library.getReadersInside());
    }

}