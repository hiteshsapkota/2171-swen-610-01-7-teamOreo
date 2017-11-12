package com.webcheckers.model.Board;

/**
 * The space class consists of an id, isValid for the piece to be put in and the {@link Piece}.
 */
public class Space {

  /**
   * Attributes
   */
  private int cellIdx;
  private Piece piece;
  public enum SPACECOLOR{
    BLACK,
    WHITE
  }
  private SPACECOLOR spaceColor;

  /**
   * Constructor
   * @param cellIdx positon of the space
   * @param piece can be null
   */
  public Space(int cellIdx, SPACECOLOR spaceColor, Piece piece) {
    this.cellIdx = cellIdx;
    this.piece = piece;
    this.spaceColor = spaceColor;
  }

  /**
   * Returns color of corresponding space
   * @return SPACECOLOR
   */
  public SPACECOLOR getSpaceColor() {
    return spaceColor;
  }

  /**
   * Returns cellIdx
   * @return cellIdx
   */
  public int getCellIdx() {
    return cellIdx;
  }

  /**
   * Sets cellIdx
   * @param cellIdx position of cell.
   */
  public void setCellIdx(int cellIdx) {
    this.cellIdx = cellIdx;
  }

  /**
   * Checks whether particular space is vaild for move or not
   * @return true if spacecolor is black and piece is not else false
   */
  public boolean isValid() {
    return this.spaceColor == SPACECOLOR.BLACK && this.piece == null;
  }

  /**
   * Returns piece
   * @return piece
   */
  public Piece getPiece() {
    return piece;
  }

  /**
   *  Sets piece
   * @param piece the piece to be set.
   */
  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}