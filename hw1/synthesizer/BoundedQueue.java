package synthesizer;


/** 
Why use interface?

An interface is a formal contract between a class and the outside world. 
If your class claims to implement an interface, 
then all methods defined by that interface must appear in your class (or somewhere in your superclass) 
before the class will successfully compile. This is a way of enforcing promised behavior. 
All methods that you declare or define are automatically public and abstract (even if you omit the public keyword).

*/
public interface BoundedQueue<T> {
    int capacity();          // return size of the buffer
    int fillCount();         // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }
}