/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

import java.util.Random;

/**
 *
 * @author benja
 */
public class Partie {
    private Joueur listeJoueurs [] = new Joueur [2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;
    
    
    public void Partie (Joueur J1, Joueur J2) { //Constructeur
        listeJoueurs [0] = J1;
        listeJoueurs [1] = J2;
        PlateauDeJeu plateau1 = new PlateauDeJeu();
    }
    
    
    private void attribuerCouleurAuxJoueurs () {
        Random r = new Random ();
        int a = r.nextInt(1);
        if (a == 0) {
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        } else {
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
    }
    
    
    private void creerEtAffecterJeton (Joueur J3) {
        for (int i=0; i<30; i++) {
            J3.ajouterJeton(new Jeton(J3.getColor()));
        }
    }
    
    public void placerTrousNoirsEtDesintegrateurs() {
        int nb = 0;
        int col = 0;
        int lig = 0;
        while (nb < 5) {
            Random ab = new Random ();
            int cd = ab.nextInt(5);
            int ef = ab.nextInt(6);
            if (plateau1.presenceTrouNoir(cd, ef) == false) {
                plateau1.placerTrouNoir(cd, ef);
            }
        }
    }
    
    
    
    
    
    public void initialiserPartie() {
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    
    public void lancerPartie() {
        
    }
}


