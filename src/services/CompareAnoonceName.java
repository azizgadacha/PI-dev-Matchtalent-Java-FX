package services;

import entities.candidature;
import entities.rendez_vous;

import java.util.Comparator;

public class CompareAnoonceName implements Comparator<rendez_vous> {
    @Override
    public int compare(rendez_vous o1, rendez_vous o2) {
        return o1.getAnnonce().getTitre().compareTo(o2.getAnnonce().getTitre());
    }
}
