package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {
    private Position position;
    @Before
    public void start()
    {
        position=new Position(5,6);

    }
@Test
    public void equals() throws Exception
{
    Position p2=new Position(5,6);
    Position p3=new Position(2,3);
    assertTrue(position.equals(p2));
    assertFalse(position.equals(p3));


}
@Test
    public void hashcode() throws Exception
{
    assertEquals(161,position.hashCode());
}
}
