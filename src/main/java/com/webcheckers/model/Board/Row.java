package com.webcheckers.model.Board;

import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import com.webcheckers.model.Board.Space.SPACECOLOR;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Row class consists of {@link Space} from 0 to 7
 */
public class Row implements Iterable<Space> {

  /**
   * list
   */
  private ArrayList<Space> spaces;

  /**
   * attributes
   */
  private int index;

  /**
   * Constructor
   * @param index position of the row
   */
  public Row(int index) {
    this.index = index;
    spaces = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      // Adding spaces
      if (index % 2 == 0) {
        if (i % 2 == 0) {
          spaces.add(new Space(i, SPACECOLOR.WHITE, null));
        } else {
          spaces.add(new Space(i, SPACECOLOR.BLACK, null));
        }
      } else {
        if (i % 2 == 0) {
          spaces.add(new Space(i, SPACECOLOR.BLACK, null));
        } else {
          spaces.add(new Space(i, SPACECOLOR.WHITE, null));
        }
      }

      // Adding pieces for the spaces
      for (int j = 0; j < 8; j++) {
        if(index == 0 || index == 1 || index == 2){
          if(spaces.get(i).getSpaceColor() == SPACECOLOR.BLACK){
            spaces.get(i).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
          }
        }
        else if(index == 5 || index == 6 || index == 7){
          if(spaces.get(i).getSpaceColor() == SPACECOLOR.BLACK){
            spaces.get(i).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
          }
        }
      }
    }
  }

  /**
   * Public methods for freemarker.
   */

  public Space getSpace(int cellIdX){
    return spaces.get(cellIdX);
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Iterator
   */
  @Override
  public Iterator<Space> iterator() {
    return spaces.iterator();
  }
}