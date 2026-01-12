package com.example.beans;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvenementBean {

    private Long id;
    private String titre;
    private Date date;
    private String lieu;
}
