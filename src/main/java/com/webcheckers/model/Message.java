package com.webcheckers.model;

/**
 * Message class sets type and text of the particular message
 */
public class Message {
    /**
     * Attributes
     */
    public String text;
        public String type;

    /**
     * Constructor with input parameters
     * @param text content of the message.
     * @param type type is info or error.
     */
        public Message(String text, String type) {
            this.text = text;
            this.type = type;
        }

    /**
     * Default constructor
     */
    Message() {}
}

