package aoc.activeobject.midle;

public interface Future <T> {
	public T get();
	public boolean isDone();
}
