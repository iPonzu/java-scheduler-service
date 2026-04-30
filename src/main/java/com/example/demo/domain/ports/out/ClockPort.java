package com.example.demo.domain.ports.out;
import java.time.LocalDateTime;

public interface ClockPort {
    LocalDateTime now();
}
