package org.example;

public class Writer extends Thread{
    private final int writerId;
    private final Library library;

    public Writer(int writerId, Library library) {
        super();
        this.writerId = writerId;
        this.library = library;
    }

    public int getWriterId() {
        return writerId;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                library.requestWrite();
                int rInside = library.getReadersInside();
                int wInside = library.getWritersInside();
                int readersEnqueued = 10 - rInside;
                int writersEnqueued = 3 - wInside;
                System.out.println("Pisarz " + writerId + " pisze. Czytelnicy w czytelni: " + rInside + " .Pisarze w czytelni: " + wInside + ". Czytelnicy w kolejce: " + readersEnqueued + ". Pisarze w kolejce: " + writersEnqueued);
                Thread.sleep(3000);
                System.out.println("Pisarz opuszcza czytelnię.");
                library.finishWrite();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
