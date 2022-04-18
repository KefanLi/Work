package EncapsulationAPIADT;

import java.util.LinkedList;

public class DelegationStack<Item> {
    private LinkedList<Item> items;

    public DelegationStack() {
        items = new LinkedList<>();
    }

    public void push(Item x) {
        items.add(x);
    }
}
