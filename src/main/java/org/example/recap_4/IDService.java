package org.example.recap_4;

import java.util.UUID;

public class IDService {
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
