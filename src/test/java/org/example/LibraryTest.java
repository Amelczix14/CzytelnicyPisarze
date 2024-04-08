package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testReadersInside() throws InterruptedException {
        Library library = new Library();
        assertEquals(0, library.getReadersInside());

        library.requestRead();
        assertEquals(1, library.getReadersInside());

        library.finishRead();
        assertEquals(0, library.getReadersInside());
    }

    @Test
    void testWritersInside() throws InterruptedException {
        Library library = new Library();
        assertEquals(0, library.getWritersInside());

        library.requestWrite();
        assertEquals(1, library.getWritersInside());

        library.finishWrite();
        assertEquals(0, library.getWritersInside());
    }

    @Test
    void testReadersEnqueued() throws InterruptedException {
        Library library = new Library();
        assertEquals(10, 10 - library.getReadersInside());

        library.requestRead();
        assertEquals(9, 10 - library.getReadersInside());

        library.finishRead();
        assertEquals(10, 10 - library.getReadersInside());
    }

    @Test
    void testWritersEnqueued() throws InterruptedException {
        Library library = new Library();
        assertEquals(3, 3 - library.getWritersInside());

        library.requestWrite();
        assertEquals(2, 3 - library.getWritersInside());

        library.finishWrite();
        assertEquals(3, 3 - library.getWritersInside());
    }

}