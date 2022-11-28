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
    
    
    public PlateauDeJeu () {
     
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
    

        for (int ligne=0;ligne<7;ligne++) {
            for (int colonne=0;colonne<8;colonne++) {
                
                grille[ligne][colonne] =  new CelluleDeGrille();             
            
            }
    
        }    
    }
    int j;
    int indLigneVide;
    public int ajouterJetonDansColonne(Jeton, j) {  // Ajoute un jeton le plus bas possible.
        //Jeton corresponds au jeton du joueur et int corresponds à son indice de colonne
        for (int i=0;i<7;i++) {  //i servira d'indice de ligne pour trouver une case vide
            if (grille[i][j]== null) { // On part de la ligne 0 (en bas) et dès qu'on trouve une ligne vide dans la colonne choisie,
                                                // on enregistre l'indice de cette ligne dans un variable "libre"
                indLigneVide=i; 
                
            } else {
            } 
            return indLigneVide;
        }
    }
    
    public boolean grilleRemplie() {
    boolean remplie;    
        for (int ligne=0;ligne<7;ligne++) {
            for (int colonne=0;colonne<8;colonne++) {
                if (grille[ligne][colonne]== null) {                   
                    remplie = false;
                    return remplie;
                }else {
                    remplie = true;
                    return remplie;
                         
                    }
                            
                         
            }
        
    }
        

    
}
    

