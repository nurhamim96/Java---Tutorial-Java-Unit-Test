package com.tutorial.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData() {
            queue.offer("Ibad Nurhamim");
            assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2 ")
        void offerMoreData() {
            queue.offer("Ibad");
            queue.offer("Nurhamim");
            assertEquals(2, queue.size());
        }
    }
}