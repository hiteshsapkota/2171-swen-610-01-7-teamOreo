package com.webcheckers.model.Board;

import com.webcheckers.model.OnlinePlayers;
import org.junit.Test;

import static com.webcheckers.model.Board.Piece.colorEnum.RED;
import static com.webcheckers.model.Board.Piece.typeEnum.SINGLE;
import static org.junit.Assert.*;

public class SpaceTest {

@Test
    public void checkSpace()
    { Piece piece = new Piece(SINGLE,RED);
        Space space=new Space(5,true, piece);
        assertEquals(5,space.getCellIdx() );
        assertEquals(true, space.isValid());
        assertEquals(RED,piece.getColor());
        assertEquals(SINGLE, piece.getType());

    }

}