package org.example;

public class Reader extends Thread{
    private final int readerId;
    private final Library library;

    public Reader(int readerId, Library library) {
        super();
        this.readerId = readerId;
        this.library = library;
    }
    public int getReaderId() {
        return readerId;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                library.requestRead();
                int rInside = library.getReadersInside();
                int wInside = library.getWritersInside();
                int readersEnqueued = 10 - rInside;
                int writersEnqueued = 3 - wInside;
                System.out.println("Czytelnik " + readerId + " czyta. Czytelnicy w czytelni: " + rInside + " .Pisarze w czytelni: " + wInside + ". Czytelnicy w kolejce: " + readersEnqueued + ". Pisarze w kolejce: " + writersEnqueued);
                Thread.sleep(1500);
                System.out.println("Czytelnik " + readerId + " opuszcza czytelnię.");
                library.finishRead();
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
