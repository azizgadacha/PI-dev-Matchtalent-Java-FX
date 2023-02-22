package services;

import entities.candidature;

import java.util.Comparator;

public class CompareNote implements Comparator<candidature> {
    @Override
    public int compare(candidature o1, candidature o2) {
        return (int) (o2.getNote()-o1.getNote());
    }
}
