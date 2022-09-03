package coder.springframework.testing.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person ;
    @BeforeEach
    void setUp() {
        person = new Person(1L,"mike","jones") ;
    }

    @Test
    void personGroupAssertion() {
    }
}