package synthesizer;
/**
What is an abstract class and why use one?

Methods and classes can be declared as abstract using the abstract keyword. 
Abstract classes cannot be instantiated, but they can be subclassed using the extends keyword. 
Unlike interfaces, abstract classes can provide implementation inheritance for features other than public methods, including instance variables.

*/

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    // "protected" just means that only subclasses of AbstractBoundedQueue can access this variable.
    protected int fillCount;
    protected int capacity;
    
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }
}

/**

Abstract Class vs Interface

In practice, in can be a little unclear when to use an interface and when to use an abstract class. 
One mostly accurate metaphor that might help is that you can think of an interface as defining a "can-do" or an "is-a" relationship,
whereas an abstract class should be a stricter "is-a" relationship. The difference can be subtle, and you can often use one instead of the other.

In practice, large Java libraries often have a hierarchy of interfaces, 
which are extended by abstract classes that provided default implementations for some methods, 
and which are in turn ultimately implemented by concrete classes. 
A good example is the Collection interface: It extends Iterable (which is its superinterface), 
and is implemented by many subinterfaces (i.e. List, Set, Map), 
which in turn have their own abstract implementations (AbstractList, AbstractSet AbstractMap). 
However, for smaller programs, the hierarchy is often stubbier, sometimes starting with an abstract class. For example, we could have just started with AbstractBoundedQueue at the top of the hierarchy and skipped having a BoundedQueue interface altogether.

*/