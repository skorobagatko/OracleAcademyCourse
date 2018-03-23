package com.skorobahatko.lectures.lecture1;

import java.util.HashMap;
import java.util.Map;

public enum Day {
    SUNDAY(7), MONDAY(1), TUESDAY(2);

    private static Map<Integer, Day> dayMap = new HashMap<>();

    static {
        for (Day day : values()) {
            dayMap.put(day.dayNumber, day);
        }
    }

    private int dayNumber;

    private Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public static Day getDayByNumber(int dayNumber) {
        Day result = null;
        for (Day day : values()) {
            if (day.getDayNumber() == dayNumber) {
                result = day;
            }
        }
        return result;
    }

    public static Day getDayByNumberMap(int dayNumber) {
        return dayMap.get(dayNumber);
    }
}
