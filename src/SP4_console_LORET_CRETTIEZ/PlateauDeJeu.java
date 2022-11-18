/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author emili
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
    
    int ligne;
    for (int ligne=0;ligne<7;ligne++) {
        for (int colonne=0;colonne<6;colonne++) {
            grille[ligne][colonne] = new CelluleDeGrille ();
        }
    
    }    

    
}

