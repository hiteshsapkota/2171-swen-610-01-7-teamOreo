package com.webcheckers.model.Board;

/**
 * Piece class consists of the type of the piece {SINGLE, KING} and color {RED, WHITE}
 */
public class Piece {

  /**
   * attributes
   */
  public typeEnum type;
  public colorEnum color;

  public Piece(typeEnum type, colorEnum color) {
    this.type = type;
    this.color = color;
  }

  /**
   * Public methods
   */
  public typeEnum getType() {
    return type;
  }

  public void setType(typeEnum type) {
    this.type = type;
  }

  public colorEnum getColor() {
    return color;
  }

  public void setColor(colorEnum color) {
    this.color = color;
  }

  public enum typeEnum {
    SINGLE,
    KING

  }

  public enum colorEnum {
    RED,
    WHITE
  }
}
