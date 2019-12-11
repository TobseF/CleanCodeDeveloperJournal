package org.cleancode.journal;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalTime;

@Service
public class MessageBean implements Serializable {

    public String getMessage() {
        return "Button was clicked at " + LocalTime.now();
    }
}
