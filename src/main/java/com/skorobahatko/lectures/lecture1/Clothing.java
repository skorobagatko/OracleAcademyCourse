package com.skorobahatko.lectures.lecture1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Clothing {

    private String name;
    private int price;

    public abstract void wash();

}
