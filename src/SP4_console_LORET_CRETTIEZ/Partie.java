/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author benja
 */
public class Partie {
    private Joueur listeJoueurs [] = new Joueur [2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;
    
    public void Partie (Joueur J1, Joueur J2) {
        listeJoueurs [0] = J1;
        listeJoueurs [1] = J2;
        PlateauDeJeu plateau1 = new PlateauDeJeu;
    }
    
    public Joueur attribuerCouleurAuxJoeurs () {
        J1.affecterCouleur("rouge");
        J2.affecterCouleur("jaune");
    }
}
