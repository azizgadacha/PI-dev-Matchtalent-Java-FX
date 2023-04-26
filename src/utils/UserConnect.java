package utils;

import entities.Utilisateur;

public class UserConnect {
    static Utilisateur user;

    public UserConnect() {
    }
    public UserConnect(Utilisateur userReceive) {
        user=userReceive;
    }

    public static Utilisateur getUser() {
        return user;
    }

    public static void setUser(Utilisateur user) {
        UserConnect.user = user;
    }
}
