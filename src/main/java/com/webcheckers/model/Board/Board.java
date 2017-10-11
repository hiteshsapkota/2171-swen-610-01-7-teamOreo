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
  public ArrayList<Row> rows = new ArrayList<>();

  /**
   * Iterator
   */
  @Override
  public Iterator<Row> iterator() {
    return rows.iterator();
  }
}
