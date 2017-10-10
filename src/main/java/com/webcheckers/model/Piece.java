package com.webcheckers.model;

public class Piece {
    public typeEnum type;
    public colorEnum color;
    public enum typeEnum{
        SINGLE,
        KING

    }
    public  enum colorEnum{
        RED,
        WHITE
    }

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
}
