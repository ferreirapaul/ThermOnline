package fr.paul.temp.presentation.rest.response;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class GetAllResponse {
    public LocalDateTime date;
    public String temp;
    public String hum;
}
