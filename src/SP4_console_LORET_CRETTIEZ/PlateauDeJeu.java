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
    CelluleDeGrille[][] grille;
    
    public PlateauDeJeu () {
     
    grille = new CelluleDeGrille[6][7];
    
        
        for (int ligne=0;ligne<=6;ligne++) {
            for (int colonne=0;colonne<=7;colonne++) {
                
                grille[ligne][colonne] =  new CelluleDeGrille();                       
            }    
        }    
    }
    
    
    int indLigneVide;
    public int ajouterJetonDansColonne(Jeton jeton, int colonne) {  // Ajoute un jeton le plus bas possible.
        //Jeton corresponds au jeton du joueur et int corresponds à son indice de colonne
        int j=colonne;
        for (int i=0;i<7;i++) {  //i servira d'indice de ligne pour trouver une case vide
            if (grille[i][j].presenceJeton()==true) { // On part de la ligne 0 (en bas) et dès qu'on trouve une ligne vide dans la colonne choisie,
                                                // on enregistre l'indice de cette ligne dans une variable "indLigneVide"
                indLigneVide++;
            } else {
                grille[i][j].affecterJeton(jeton);
            }
        return indLigneVide;
        }
    }
    
    public boolean grilleRemplie() {
    boolean remplie = true;    
        for (int ligne=0;ligne<=6;ligne++) {
            for (int colonne=0;colonne<=7;colonne++) {
                if (grille[ligne][colonne].presenceJeton()==false) {                   
                    remplie = false;
                    return remplie;               
                }
            } 
        }
        return remplie;}
    }
    
    
    public String afficherGrilleSurConsole() {
        for (int i=1;i<=6;i++) {
            for (int j=1;i<=7;j++) {
                System.out.print(grille[i][j].toString());
            }
        }
    }
        
    
    
    
    
    
}
    

