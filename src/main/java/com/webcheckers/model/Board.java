package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Row>{
    public ArrayList<Row> rows = new ArrayList<>();
    @Override
    public Iterator<Row> iterator()
    {
    return rows.iterator();
    }
}
