package fr.paul.temp.data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperatures")
public class TempsModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public long id;
    public LocalDateTime date;
    public String temp;
    public String hum;
}
