package com.webcheckers.model.Board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Row class consists of {@link Space} from 0 to 7
 */
public class Row implements Iterable<Space> {

  /**
   * list
   */
  public ArrayList<Space> spaces = new ArrayList<>();

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
  }

  /**
   * Public methods for freemarker.
   */

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
