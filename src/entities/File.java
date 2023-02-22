/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
/**
 *
 * @author Istabrak
 */
public class File {
    private int idFile;
    private Type type;
    private int idUtilisateur;

    
    
public File(){
}

    public File(int idFile, Type type, int idUtilisateur) {
        this.idFile = idFile;
        this.type = type;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "File{" + "idFile=" + idFile + ", type=" + type + ", idUtilisateur=" + idUtilisateur + '}';
    }

}
