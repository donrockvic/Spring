package com.spring.test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FooTest {
    @Test
    void getBar(){
        Foo foo = new Foo();
        String result  = foo.getBar();
        assertEquals("Foo bar", result);
    }
}
