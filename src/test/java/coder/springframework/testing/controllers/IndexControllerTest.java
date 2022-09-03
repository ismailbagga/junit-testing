package coder.springframework.testing.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController ;
    @BeforeEach
    void setUp() {
        indexController = new IndexController() ;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void index() {
        assertEquals("index",indexController.index());
        assertNotEquals("index!",indexController.index(),"wrong view name");

    }
    @Test
    void login() {
        assertEquals("login",indexController.login());
        assertNotEquals("login!",indexController.index(),"wrong view name");

    }
}