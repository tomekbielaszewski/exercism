import java.util.Arrays;

public class CircularBuffer<T> {
    private Object[] data;
    private int readPointer;
    private int writePointer;

    CircularBuffer(int size) {
        this.data = new Object[size];
    }

    public T read() throws BufferIOException {
        if (isEmpty()) throw new BufferIOException("Tried to read from empty buffer");
        T entry = (T) data[readPointer];
        data[readPointer] = null;
        readPointer = incrementPointer(readPointer);
        return entry;
    }

    public void write(T entry) throws BufferIOException {
        if(isFull()) throw new BufferIOException("Tried to write to full buffer");
        data[writePointer] = entry;
        writePointer = incrementPointer(writePointer);
    }

    public void overwrite(T entry) throws BufferIOException {
        if(isFull()) {
            data[writePointer] = entry;
            writePointer = incrementPointer(writePointer);
            readPointer = incrementPointer(readPointer);
        } else {
            write(entry);
        }
    }

    public void clear() {
        Arrays.fill(this.data, null);
        readPointer = writePointer = 0;
    }

    private boolean isEmpty() {
        return this.data[readPointer] == null;
    }

    private boolean isFull() {
        return this.data[writePointer] != null;
    }

    private int incrementPointer(int pointer) {
        return ++pointer >= this.data.length ? 0 : pointer;
    }
}
