/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author emili
 */
public class SP4_console_LORET_CRETTIEZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Joueur joueur1 = new Joueur ("Emilien"); //Création des joueurs
    Joueur joueur2 = new Joueur ("Benjamin");
    Partie partie1 = new Partie (joueur1, joueur2); //Création de la partie
    partie1.initialiserPartie(); //Initialisation
    partie1.lancerPartie(); //Lancement 
    
    //PlateauDeJeu plateau = new PlateauDeJeu();
    //plateau.afficherGrilleSurConsole();
    }
    
}
