package services;

import entities.Postulation;

import java.util.Comparator;

public class Compoare_Address_Postulation  implements Comparator<Postulation> {
    @Override
    public int compare(Postulation o1, Postulation o2) {
        return o1.getUtilisateur().getUsername().compareTo(o2.getUtilisateur().getUsername());

    }
}
