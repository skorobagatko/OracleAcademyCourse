package com.skorobahatko.practices.practice2;

import java.util.Objects;

public class RatingPosition {

    private int rank;
    private String maleName;
    private String femaleName;

    public RatingPosition(int rank, String maleName, String femaleName) {
        this.rank = rank;
        this.maleName = maleName;
        this.femaleName = femaleName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingPosition that = (RatingPosition) o;
        return rank == that.rank &&
                Objects.equals(maleName, that.maleName) &&
                Objects.equals(femaleName, that.femaleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rank, maleName, femaleName);
    }

    @Override
    public String toString() {
        return "RatingPosition{" +
                "rank=" + rank +
                ", maleName='" + maleName + '\'' +
                ", femaleName='" + femaleName + '\'' +
                '}';
    }
}
