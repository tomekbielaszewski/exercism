import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class HandshakeCalculator {
    private static final int REVERSE_MASK = 0b10000;

    List<Signal> calculateHandshake(int number) {
        return Arrays.stream(Signal.values())
                .filter(signal -> (0b1 << signal.ordinal() & number) > 0)
                .collect(
                        LinkedList::new,
                        isReversed(number) ? LinkedList::addFirst : LinkedList::addLast,
                        LinkedList::addAll
                );
    }

    private boolean isReversed(int number) {
        return (number & REVERSE_MASK) > 0;
    }
}
