package com.skorobahatko.lectures.lecture1;

import lombok.*;

public class Shape {
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @NoArgsConstructor
    @EqualsAndHashCode
    protected static class Color {
        private int red;
        private int green;
        private int blue;
    }
}
