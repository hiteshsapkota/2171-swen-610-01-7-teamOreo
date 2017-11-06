package com.webcheckers.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTest {

    @Test
    public void checkMessage(){
        Message message = new Message();
        assertNull(message.text);
        assertNull(message.type);
        message = new Message("test1", "test2");

        assertNotNull(message.text);
        assertNotNull(message.type);

        assertEquals("test1", message.text);
        assertEquals("test2", message.type);
    }

}