package com.webcheckers.model.Board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Board contains a list of {@link Row} from 0 to 7
 */
public class Board implements Iterable<Row> {

  /**
   * Lists
   */
  private ArrayList<Row> rows;

  public Board(){
    rows = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      rows.add(new Row(i));
    }
  }

  public Row getRow(int index){
    return rows.get(index);
  }

  /**
   * Iterator
   */
  @Override
  public Iterator<Row> iterator() {
    return rows.iterator();
  }
}
