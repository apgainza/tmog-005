package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MinStackTest {

    @Test
    void push() {
        int topDataExpected = -10;
        int minValueExpected = -10;

        MinStack data = new MinStack();
        data.push(23);
        data.push(-2);
        data.push(-1);
        data.push(0);
        data.push(-10);

        assertAll(
                () -> assertEquals(data.top(), topDataExpected),
                () -> assertEquals(data.getMin(), minValueExpected)
        );
    }

    @Test
    void pop() {
        int topDataExpected = -2;
        int minValueExpected = -2;

        MinStack data = new MinStack();
        data.push(23);
        data.push(-2);
        data.push(-1);
        data.pop();

        assertAll(
                () -> assertEquals(data.top(), topDataExpected),
                () -> assertEquals(data.getMin(), minValueExpected)
        );
    }

    @Test
    void top() {
        int topDataExpected = -2;

        MinStack data = new MinStack();
        data.push(23);
        data.push(-2);
        data.push(-1);
        data.push(23);
        data.push(-2);
        data.push(-10);
        data.push(23);
        data.push(-2);
        data.push(-1);
        data.push(23);
        data.push(-2);

        assertEquals(data.top(), topDataExpected);
    }

    @Test
    void getMin() {
        int minValueExpected = -15;

        MinStack data = new MinStack();
        data.push(23);
        data.push(-2);
        data.push(-1);
        data.push(23);
        data.push(-2);
        data.push(-10);
        data.push(23);
        data.push(-2);
        data.pop();
        data.pop();
        data.pop();
        data.push(-15);

        assertEquals(data.getMin(), minValueExpected);
    }

}