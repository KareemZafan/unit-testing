package org.procode.app;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    ArrayList<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public List<Integer> getCurrentStack() {
        return list;
    }

    public int pop() throws Exception {
        if(list.isEmpty()) throw new Exception("Emtpy List");
        int poppedItem = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return poppedItem;
    }

    public int getPeek() {
        return list.get(getSize() - 1);
    }
}
