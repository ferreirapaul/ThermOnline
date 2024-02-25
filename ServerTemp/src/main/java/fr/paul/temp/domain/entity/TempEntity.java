package fr.paul.temp.domain.entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TempEntity {
    public LocalDateTime date;
    public String temp;
    public String hum;
}
