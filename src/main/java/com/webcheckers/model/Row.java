package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Row implements Iterable<Space> {
    public ArrayList<Space> spaces = new ArrayList<>();
    public int index;

    public int getIndex(){
        return index;
    }
    
    public void setIndex(int index) {
        this.index=index;
    }

    public Row(int index){
        this.index=index;
    }

    @Override
    public Iterator<Space> iterator() {
        return spaces.iterator();
    }
}
