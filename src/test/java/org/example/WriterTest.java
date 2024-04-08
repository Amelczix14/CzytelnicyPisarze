package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    @Test
    void testGetWriterId(){
        Library library = new Library();
        Writer writer = new Writer(1, library);

        assertEquals(1, writer.getWriterId());
    }

    @Test
    void testWriter()throws InterruptedException{
        Library library = new Library();
        Writer writer = new Writer(1, library);

        assertEquals(0,library.getWritersInside());
        writer.start();
        Thread.sleep(2000);
        assertEquals(1,library.getWritersInside());
    }

}