/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author benja
 */
public class Jeton {
    private String couleur;
    String codecoul;
    public Jeton (String color) {
        couleur = color;
        if (color == "rouge") {
            codecoul = "R";
        } else if (color == "jaune") {
            codecoul = "J";
        } else {
            System.out.println("Problème de couleur, il n'y a que deux choix possibles : rouge ou jaune");
        }
    }
    
   
    public String lireCouleur () {
        String retour;
        retour = couleur;
        return retour;
    }
    
    @Override
    public String toString() {
        String retourner;
        retourner = codecoul;
        return retourner;
    }
}
