package InheritanceImplements;

public class RotatingSLList<T> extends SLList<T> {
    public void rotateRight() {
        T item = removeLast();
        addFirst(item);
    }
}
