package org.example;

import java.util.concurrent.Semaphore;

public class Library{
    private final Semaphore readerSemaphore = new Semaphore(5);
    private final Semaphore writerSemaphore = new Semaphore(1);
    private int readersInside = 0;
    private int writersInside = 0;

    /**
     * This method is used to request permission for reading access.
     * It employs a semaphore to control concurrent access, ensuring that multiple
     * readers can access the shared resource concurrently while preventing writers
     * from accessing it simultaneously.
     * @throws InterruptedException exception is thrown when the thread is interrupted, either before or during the activity
     */
    public void requestRead() throws InterruptedException{
        readerSemaphore.acquire();
        readersInside++;
    }

    /**
     * After finishing reading, the method releases the
     * reader semaphore, indicating that the reader has completed its access.
     */
    public void finishRead(){
        readerSemaphore.release();
        readersInside--;
    }

    /**
     * This method is used to request permission for writing access.
     * It acquires the writer semaphore to ensure exclusive access for a writer
     * and also acquires the reader semaphore with a limit of 5 permits,
     * preventing concurrent reading during a write operation.
     * @throws InterruptedException exception is thrown when the thread is interrupted, either before or during the activity
     */
    public void requestWrite() throws InterruptedException{
        writerSemaphore.acquire();
        readerSemaphore.acquire(5);
        writersInside++;
    }

    /**
     * After finishing writing, the method releases the
     * writer semaphore, indicating that the writer has completed its access, and also
     * releases the reader semaphore to allow concurrent reading.
     */
    public void finishWrite(){
        writerSemaphore.release();
        readerSemaphore.release(5);
        writersInside--;
    }

    public int getReadersInside() {
        return readersInside;
    }

    public int getWritersInside() {
        return writersInside;
    }
}


