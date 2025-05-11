package org.example;

import org.example.server.EmbeddedServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws  Exception {
        new EmbeddedServer().start();
    }
}
