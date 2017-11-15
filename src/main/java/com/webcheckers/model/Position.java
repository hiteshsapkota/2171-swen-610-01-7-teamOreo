package com.webcheckers.model;

class Position{
  private final int x;
  private final int y;

  Position(int x, int y){
    this.x = x;
    this.y = y;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Position position = (Position) o;

    return x == position.x && y == position.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
