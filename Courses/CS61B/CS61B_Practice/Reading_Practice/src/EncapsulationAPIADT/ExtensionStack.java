package EncapsulationAPIADT;

import java.util.LinkedList;

public class ExtensionStack<Item> extends LinkedList<Item> {
    public void push(Item x) {
        this.add(x);
    }
}
