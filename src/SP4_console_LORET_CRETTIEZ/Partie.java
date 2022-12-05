/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

import java.util.Random;
import java.util.Scanner;

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
        int col;
        int lig;
        int nombre1 = 0;
        int nombre2 = 0;
        while (nb < 3) { //On s'occupe des trois premiers trous noirs et desintegrateurs 
            Random ab = new Random ();
            col = ab.nextInt(6); //Tire un chiffre entre 0 et 6
            lig = ab.nextInt(5); //Tire un chiffre entre en 0 et 5
            if (plateau.presenceTrouNoir(lig, col) == false) { //Si il n'y a pas de trou noir
                plateau.placerTrouNoir(lig, col); //On en place un
                if (plateau.presenceDesintegrateur(lig, col) == false) { //Si il n'y a pas de désintégrateur
                    plateau.placerDesintegrateur(lig, col); //On en place un
                    nb += 1; //On ajoute 1 pour petit à petit sortir de la boucle while
                }
            }
        }
        //Ici nb = 3
        while (nb < 5) { //On s'occupe des derniers trous noirs et désintégrateurs
            while (nombre1 < 2) { //En premier les trous noirs
                Random cd = new Random ();
                col = cd.nextInt(6);
                lig = cd.nextInt(5);
                if (plateau.presenceTrouNoir(lig, col) == false) {
                plateau.placerTrouNoir(lig, col);
                nombre1 += 1;
                } 
            }   
            while (nombre2 < 2) { //En deuxième les désintégrateurs
                Random ef = new Random ();
                col = ef.nextInt(6);
                lig = ef.nextInt(5);
                if (plateau.presenceTrouNoir(lig, col) == false) {
                    //Les premiers trous noirs et désintégrateurs sont aux mêmes endroits
                    //Les autres trous noirs ne doivent pas etre confondu avec les désintégrateurs
                    //On verifie donc si il n'y a pas de trou noir
                    plateau.placerDesintegrateur(lig, col);
                    nombre2 += 1;
                }
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
        joueurCourant = listeJoueurs[0];
        boolean fin = false;
        int choix;
        int colonne;
        int ligne;
        while (fin == false) {
            Scanner scan = new Scanner(System.in);
            plateau.afficherGrilleSurConsole();
            System.out.println("C'est au tour de " + joueurCourant + " de jouer, couleur : "+joueurCourant.getColor());
            choix = 4;
            while (choix > 0 && choix < 4) {
                System.out.println("Action possible");
                System.out.println("Placer un jeton : 1");
                System.out.println("Récupérer un jeton : 2");
                System.out.println("Utiliser un désintégrateur : 3");
                choix = scan.nextInt();
            }
            if (choix == 1 ) {
                colonne = 10;
                while (colonne < 1 && colonne > 7) {
                   System.out.println("Dans quelle colonne souhaitez vous placer votre jeton ? (colonne 1 à 7");
                   colonne = scan.nextInt();
                }
                while (plateau.colonneRemplie(colonne) == true) { //Il faut mettre le plateau?
                    System.out.println("La colonne est pleine, choisissez une autre colonne");
                    colonne = scan.nextInt();
                }
                ligne = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne);
                
            }
        }
    }
}


