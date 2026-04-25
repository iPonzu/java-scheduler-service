package com.example.demo.adapters.out.time.adapter;

import com.example.demo.domain.ports.out.ClockPort;
import java.time.LocalDateTime;

public class SystemClockAdapter implements ClockPort {
    @Override
    public LocalDateTime now(){
        return LocalDateTime.now();
    }
}
