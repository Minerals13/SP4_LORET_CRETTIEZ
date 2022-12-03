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
    private String Nom; //Déclaration de l'attribut Nom (type String)
    private String Color; //Déclaration de l'attribut Color (type String)
    private ArrayList<Jeton> reserveJetons = new ArrayList(); //Déclaration de l'attribut reserveJetons (type ArrayList<Jeton>), c'est un tableau dynamique
    private int nombreDesintegrateurs; //Déclaration de l'attribut nombreDesintegrateurs (type int)
    
    public Joueur (String nom) {
        Nom = nom; //Nom prend la valeur du paramètre nom
        nombreDesintegrateurs = 0; //Initialisation de l'attribut à 0
    }
    
    public void affecterCouleur (String couleur) { //méthode void donc ne renvoie rien
        Color = couleur; //Color prend la valeur du paramètre couleur
    }
    
    public int nombreDeJetons () {
        int nbJetons = reserveJetons.size(); //Déclaration de la variable et initialisation
        //La variable prend la valeur de la taille du tableau reserveJetons
        return nbJetons; //Retourne la variable
    }

    public String getColor() {
        return Color; //Retourne la valeur de l'attribut Color
    }
    
    public void ajouterJeton (Jeton jet) {
        reserveJetons.add(jet); //Ajoute des jetons (jet) au tableau dynamique reserveJetons
    }
    
    public Jeton jouerJeton () {
        Jeton useJeton; //Déclaration et initialisation de la variable useJeton (type Jeton)
        //Récupère et stock la référence du premier jeton de la réserve (tableau reserveJetons) dans la variable
        useJeton = reserveJetons.remove(0); //Supprime le premier jeton de la réserve
        //Récupère et stock la référence du premier jeton de la réserve (tableau reserveJetons) dans la variable
        return useJeton; //Retourne le jeton
    }
    
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs++; //Ajoute +1 au nombre de désintégrateurs
    }
    
    public void utiliserDesintegrateur() {
        nombreDesintegrateurs--; //Enleve -1 au nombre de désintégrateurs
    }
}
