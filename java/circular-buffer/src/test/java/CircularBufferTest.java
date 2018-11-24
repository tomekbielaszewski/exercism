import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CircularBufferTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void readingFromEmptyBufferShouldThrowException() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Test
    public void canReadItemJustWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));
    }

    @Test
    public void canReadItemOnlyOnce() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Test
    public void readsItemsInOrderWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read(), is(1));
        assertThat(buffer.read(), is(2));
    }

    @Test
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to write to full buffer");
        buffer.write(2);
    }

    @Test
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));
        buffer.write(2);
        assertThat(buffer.read(), is(2));
    }

    @Test
    public void maintainsReadPositionAcrossWrites() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read(), is(1));
        buffer.write(3);
        assertThat(buffer.read(), is(2));
        assertThat(buffer.read(), is(3));
    }

    @Test
    public void cantReadClearedItems() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Test
    public void clearFreesUpCapacity() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertThat(buffer.read(), is(2));
    }

    @Test
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertThat(buffer.read(), is(1));
    }

    @Test
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertThat(buffer.read(), is(1));
        assertThat(buffer.read(), is(2));
    }

    @Test
    public void overwriteRemovesOldestElementOnFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        assertThat(buffer.read(), is(2));
        assertThat(buffer.read(), is(3));
    }

    @Test
    public void overwriteDoesntRemoveAnAlreadyReadElement() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        assertThat(buffer.read(), is(1));
        buffer.write(4);
        buffer.overwrite(5);
        assertThat(buffer.read(), is(3));
        assertThat(buffer.read(), is(4));
        assertThat(buffer.read(), is(5));
    }
}

