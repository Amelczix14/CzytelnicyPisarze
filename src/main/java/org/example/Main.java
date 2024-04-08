package org.example;

public class Main
{
    public static void main( String[] args )
    {
        Library library = new Library();

        for (int i = 1; i <= 10; i++) {
            Reader reader = new Reader(i, library);
            reader.start();
        }

        for (int i = 1; i <= 3; i++) {
            Writer writer = new Writer(i, library);
            writer.start();
        }
    }
}
