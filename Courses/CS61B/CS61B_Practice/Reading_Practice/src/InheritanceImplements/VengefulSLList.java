package InheritanceImplements;

public class VengefulSLList<Item> extends SLList<Item>{
    SLList<Item> deletedItems = new SLList<Item>();

    public void printLostItems() {
        deletedItems.print();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }
}
