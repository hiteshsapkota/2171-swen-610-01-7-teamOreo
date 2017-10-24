package com.webcheckers.model.Board;

import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {

    @Test
    public void checkSameIndex()
    {
        Row row=new Row(5);
        assertEquals(5,row.getIndex());
    }

}