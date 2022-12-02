/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class Joueur {
    private String Nom;
    private String Color;
    private ArrayList<Jeton> reserveJetons = new ArrayList();
    
    public Joueur (String nom) {
        Nom = nom;
        int nbDesintegrateur = 0;
    }
    
    public void affecterCouleur (String couleur) {
        Color = couleur;
    }
    
    public int nombreDeJetons () {
        int nbJetons = reserveJetons.size();
        return nbJetons;
    }

    public String getColor() {
        return Color;
    }
    
    public void ajouterJeton (Jeton jet) {
        reserveJetons.add(jet);
    }
    
    public Jeton jouerJeton () {
        Jeton useJeton = reserveJetons.get(0);
        reserveJetons.remove(0);
        return useJeton;
    }
}
