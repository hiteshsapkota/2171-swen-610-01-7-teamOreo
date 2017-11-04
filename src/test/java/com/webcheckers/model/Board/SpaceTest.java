//package com.webcheckers.model.Board;
//
//import com.sun.org.apache.regexp.internal.RE;
//import com.webcheckers.model.OnlinePlayers;
//import org.junit.Test;
//
//import static com.webcheckers.model.Board.Piece.colorEnum.RED;
//import static com.webcheckers.model.Board.Piece.typeEnum.SINGLE;
//import static org.junit.Assert.*;
//
//public class SpaceTest {
//
//@Test
//    public void checkSpace()
//    { Piece piece = new Piece(SINGLE,RED);
//        Space space=new Space(5,true, piece);
//        assertEquals(5,space.getCellIdx() );
//        assertEquals(true, space.isValid());
//        assertEquals(RED,piece.getColor());
//        assertEquals(SINGLE, piece.getType());
//
//    }
//
//    @Test
//    public void checkSetIdx(){
//        int targetId = 5;
//        Space space = new Space(7, true, null);
//        space.setCellIdx(targetId);
//        assertEquals(targetId, space.getCellIdx());
//    }
//
//    @Test
//    public void checkSetValid(){
//        boolean targetValid = false;
//        Space space = new Space(5, true, null);
//        space.setValid(targetValid);
//
//        assertFalse(space.isValid());
//    }
//
//    @Test
//    public void checkGetAndSetPiece(){
//        Piece targetPiece = new Piece(SINGLE, RED);
//        Space space = new Space(5, true, null);
//
//        space.setPiece(targetPiece);
//        assertEquals(targetPiece, space.getPiece());
//    }
//
//}