import java.util.concurrent.atomic.AtomicInteger;

public class Counter2 implements Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public void inc() {
        value.getAndIncrement();
    }

    public void dec() {
        value.getAndDecrement();
    }

    public int get() {
        return value.get();
    }
}
