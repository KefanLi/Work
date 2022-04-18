package EncapsulationAPIADT;

import java.util.List;

public class StackAdapter<Item> {
    private List<Item> items;

    public StackAdapter(List<Item> L) {
        items = L;
    }

    public void push(Item x) {
        items.add(x);
    }
}
