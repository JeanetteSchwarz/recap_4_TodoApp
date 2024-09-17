package org.example.recap_4;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IDService {
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
