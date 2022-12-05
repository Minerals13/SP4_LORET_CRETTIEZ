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
    
        
        for (int ligne=0;ligne<6;ligne++) {
            for (int colonne=0;colonne<7;colonne++) {
                
                grille[ligne][colonne] =  new CelluleDeGrille();                       
            }    
        }    
    }
    
    
    int indLigneVide;
    public int ajouterJetonDansColonne(Jeton jeton, int colonne) {  // Ajoute un jeton le plus bas possible.
        //Jeton corresponds au jeton du joueur et int corresponds à son indice de colonne
        int j=colonne;
        for (int i=0;i<6;i++) {  //i servira d'indice de ligne pour trouver une case vide
            if (grille[i][j].presenceJeton()==true) { // On part de la ligne 0 (en bas) et dès qu'on trouve une ligne vide dans la colonne choisie,
                                                // on enregistre l'indice de cette ligne dans une variable "indLigneVide"
                indLigneVide++;
            } else {
                grille[i][j].affecterJeton(jeton);
            }
        
        }
        return indLigneVide;
    }
    
    public boolean grilleRemplie() {
    boolean remplie = true;    
        for (int ligne=0;ligne<6;ligne++) {
            for (int colonne=0;colonne<7;colonne++) {
                if (grille[ligne][colonne].presenceJeton()==false) {                   
                    remplie = false;
                    return remplie;               
                }
            } 
        }
        return remplie;
    }
    
    public void afficherGrilleSurConsole() {
        for (int i=0;i<6;i++) {
            for (int j=0;i<7;j++) {
                if (j==6) {
                    System.out.println("\n");                                      
                } else {
                    System.out.println(grille[i][j].toString());
                }
            }
        }
    }
    
    public boolean presenceJeton(int x, int y) {
        if (grille[x][y].presenceJeton()==true){
            return true;
                }   
        return false;
    }
    
    public String lireCouleurDuJeton(int x, int y) {
        return grille[x][y].lireCouleurDuJeton();
       
    }
        
    public boolean colonneGagnantePourCouleur(String couleur) { //Métohde qui annonce si la couleur sélectionnée  est gagnante sur les lignes
        int cpt =0;
        boolean gagnant = false;
        for (int j=0;j<7;j++) {
            for (int i=0;i<6;i++) {
                if (grille[i][j].lireCouleurDuJeton()== couleur ) {
                    cpt=+1;
                    if (cpt==4) {   
                        gagnant = true; 
                        return gagnant;
                    }     
                }
            }
        }
        return gagnant;        
    }
    
    public boolean ligneGagnantePourCouleur (String couleur) {
        int cpt=0;
        boolean gagnant = false;
        for (int i=0; i<6;i++) {
            for (int j=0;j<7;j++) {
                if (grille[i][j].lireCouleurDuJeton() == couleur) {
                    cpt=+1;
                    if (cpt==4) {
                        gagnant = true;
                        return gagnant;
                    }                         
                }
            }
        }
        return gagnant;             
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur (String couleur) {
        boolean gagnant = false;
        for (int i = 0; i<=2; i++) {
            for (int j = 0; j<=3; j++) {
                if (grille[i][j].lireCouleurDuJeton() == couleur) {
                    if (grille[i+1][j+1].lireCouleurDuJeton() == couleur && grille[i+2][j+2].lireCouleurDuJeton() == couleur && grille[i+3][j+3].lireCouleurDuJeton() == couleur) {
                        gagnant = true;
                        return gagnant;
                    }
                }
            }
        }
        return gagnant;
    }
           
     public boolean diagonaleDescendanteGagnantePourCouleur(String couleur) {
        boolean gagnant = false;
        for (int i = 5; i>=3; i--) {
            for (int j = 0; j<=4; j--) {
                if (grille[i][j].lireCouleurDuJeton() == couleur) {
                    if (grille[i-1][j+1].lireCouleurDuJeton() == couleur && grille[i-2][j+2].lireCouleurDuJeton() == couleur && grille[i-3][j+3].lireCouleurDuJeton() == couleur) {
                        gagnant = true;
                        return gagnant;
                    }
                }
            }
        }
        return gagnant;
    }
    public boolean etreGagnantePourCouleur(String couleur){
        if ( ligneGagnantePourCouleur (couleur) == true && colonneGagnantePourCouleur (couleur) == true && diagonaleMontanteGagnantePourCouleur (couleur) == true && diagonaleDescendanteGagnantePourCouleur (couleur) == true ) {
            return  true ;
        }
        else {
            return  false ;
        }
    }  
    
    public void tasserColonne(int indColonne) {
        for (int i = 0; i<5; i++) {
            if (grille[i][indColonne].presenceJeton() == false) {
                if (grille[i+1][indColonne].presenceJeton() == true) {
                    grille[i][indColonne].affecterJeton(grille[i+1][indColonne].recupererJeton()); // Récupère le jeton de la ligne n+1 pour la mettre à la ligne n
                    grille[i+1][indColonne].supprimerJeton();
                }
            }
        }
    }
    
    public boolean colonneRemplie(int indColonne) {
        boolean remplie =false;
        int indLigne=5;
        if (grille[indLigne][indColonne].presenceJeton()==true){
            remplie=true;
            return remplie;
        } else {
            remplie =false;  
            return remplie;
        }
        }
    
    
    public boolean presenceTrouNoir(int i, int j){
        if (grille[i][j].presenceTrouNoir()==true){
            return true;
        }
        else{
            return false;
        }     
    }
    
    public void placerTrouNoir(int i, int j) {
        grille[i][j].placerTrouNoir();
    }  
    
    public void supprimerTrouNoir(int i, int j){
        grille[i][j].supprimerTrouNoir();
    }
    
    /////////////
    
    
    public boolean presenceDesintegrateur (int i, int j) {
        if (grille[i][j].presenceDesintegrateur()==true){
            return true;
        }else {
            return false;                   
        }
    }
    
    public void supprimerDesintegrateur(int i, int j){
        grille[i][j].supprimerTrouNoir();
    }
        
    public void placerDesintegrateur(int i, int j){
        grille[i][j].placerDesintegrateur();
    }    
    
    ////////////
    
    public void supprimerJeton(int i, int j){
        grille[i][j].supprimerJeton();
    }
    
    public Jeton recupererJeton(int i, int j){
        return grille[i][j].recupererJeton();    
    }   
    
    


    
}
    

