public abstract class Queue <T>{
    public abstract void put( T element);
    public abstract T get();
    public abstract boolean isEmpty();
    public abstract void growIfNeeded();
    public abstract String toString();
}
