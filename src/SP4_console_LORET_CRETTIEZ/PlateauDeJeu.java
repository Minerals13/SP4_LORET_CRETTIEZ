/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/////VIDEO : cellule = cellule de grille
/////VIDEO : cellule[][] = grille [][]

/**
 *
 * @author emili
 */
public class PlateauDeJeu {  //Initialisation d'un constructeur
    CelluleDeGrille[][] grille; //
    
    public PlateauDeJeu () {
     
    grille = new CelluleDeGrille[6][7];  //Création d'un tableau 6*7 cases, composé par des éléments de type CelluleDeGrille
    
        
        for (int ligne=0;ligne<6;ligne++) {
            for (int colonne=0;colonne<7;colonne++) {
                
                grille[ligne][colonne] =  new CelluleDeGrille();       //On parcours case par case pour remplacer chaque case vide par un nouvel objet CelluleDeGrille                
            }    
        }    
    }
    
    
      int indLigneVide = 0;
    public int ajouterJetonDansColonne(Jeton jeton, int colonne) {  // Ajoute un jeton le plus bas possible.
        //Jeton corresponds au jeton du joueur et int corresponds à son indice de colonne
        int j=colonne;
        for (int i=0;i<6;i++) {  //i servira d'indice de ligne pour trouver une case vide
            if (grille[i][j].presenceJeton()==true) { // On part de la ligne 0 (en bas) et dès qu'on trouve une ligne vide dans la colonne choisie,
                                                // on enregistre l'indice de cette ligne dans une variable "indLigneVide"
                indLigneVide++;
            
                
            }
        
        }
        grille[indLigneVide][colonne].affecterJeton(jeton);
        return indLigneVide;
    }
    
    public boolean grilleRemplie() { // Méthode qui nous indique si la grille est remplie en vérifiant si toutes les cases sont remplies par des objets de types Jeton
    boolean remplie = true;    //On part du principe qu'elle est remplie, sauf si on détecte la présence  d'un jeton dans une des cases 
        for (int ligne=0;ligne<6;ligne++) {
            for (int colonne=0;colonne<7;colonne++) {
                if (grille[ligne][colonne].presenceJeton()==false) {    //Si la case est vide, on retourne false, sinon, on retourne true               
                    remplie = false;
                    return remplie;               
                }
            } 
        }
        return remplie; //Si il n'y a aucune présence de jeton, on retourne que la grille est remplie
    }
    
    public void afficherGrilleSurConsole() { //Méthode qui affiche notre grille remplie sur la base de la méthode toString
        for (int i=0;i<6.;i++) { //On parcourt toutes les lignes une par une, en affichant à chaque fois toute la ligne en changeant l'indice de colonne
            for (int j=0;j<7;j++) {
                System.out.print(grille[i][j]+" ");
            }
            System.out.println(" "+(i+1));
            
                
                
            }
        }
    
    
    public boolean presenceJeton(int x, int y) { //Méthode qui permets de savoir si il y a un jeton en x,y (correspondant à la xème ligne et yème colonne)
        if (grille[x][y].presenceJeton()==true){
            return true; //On retourne true si y'a un jeton en x,y
                }   
        return false; //On retourne false c'est vide en x,y
    }
    
    public String lireCouleurDuJeton(int x, int y) { //Méthode qui permets de savoir la couleur du jeton en x,y (correspondant à la xème ligne et yème colonne)
        return grille[x][y].lireCouleurDuJeton(); //On retourne la couleur du jeton en x,y
       
    }
        
    public boolean colonneGagnantePourCouleur(String couleur) { //Métohde qui annonce si la couleur sélectionnée  est gagnante sur les lignes , couleur représente la couleur dont on veut vérifier la victoire ou non
        int cpt =0;  //On initialise un compteur à 0
        boolean gagnant = false; //Par principe, on a pas gagné
        for (int j=0;j<7;j++) {
            for (int i=0;i<6;i++) {
                if (grille[i][j].lireCouleurDuJeton()== couleur ) {  //On parcours tous les cases une par une et on vérifie si la cases en i,j corresponds à la couleur choisie pour vérification
                    cpt=+1;  //Si c'est la même, on ajoute 1 à notre compteur
                    if (cpt==4) {    //Si le compteur atteint 4, ça veut dire qu'on a 4 jetons qui se suivent sur une ligne et donc c'est gagné
                        gagnant = true;  //On retourne que la couleur sélectionnée a gagnéen retournant true
                        return gagnant;
                    }     
                }
            }
        }
        return gagnant;        //Si on termine la double imbrication sans avoir notre compteur à 4, c'est qu'on a pas gagné et donc on retourne false
    }
    
    public boolean ligneGagnantePourCouleur (String couleur) { //Méthode qui annonce si la couleur sélectionnée est gagnante sur les lignes, couleur représente la couleur dont on veut vérifier la victoire ou non
        int cpt=0; //On initialise un compteur à 0
        boolean gagnant = false; //Par principe, on a pas gagné
        for (int i=0; i<6;i++) {  
            for (int j=0;j<7;j++) {
                if (grille[i][j].lireCouleurDuJeton() == couleur) { //On parcours tous les cases une par une et on vérifie si le jeton en i,j corresponds à la couleur choisie pour vérification
                    cpt=+1; //Si c'est la même, on ajoute 1 à notre compteur
                    if (cpt==4) { //Si le compteur atteint 4, ça veut dire qu'on a 4 jetons qui se suivent sur une colonne et donc c'est gagné
                        gagnant = true;
                        return gagnant; //On retourne que la couleur sélectionnée a gagné en retournant true
                    }                         
                }
            }
        }
        return gagnant;             
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur (String couleur) {//Mérhode pour savoir si on a gagné sur une diagonale montante
        boolean gagnant = false;
        for (int i = 0; i<=2; i++) {  //On navigue ligne par ligne mais que sur les 3 premières
            for (int j = 0; j<=3; j++) { //On navigue colonne par colonne mais que sur les 4 premières
                if (grille[i][j].lireCouleurDuJeton() == couleur) { //On se place sur une case où la couleur du jeton est la même que celle choisie pour vérification
                    if (grille[i+1][j+1].lireCouleurDuJeton() == couleur && grille[i+2][j+2].lireCouleurDuJeton() == couleur && grille[i+3][j+3].lireCouleurDuJeton() == couleur) {
                        //On regarde les couleurs des cases en diagonanles montantes par rapport à notre case de base, si les 3 suivantes (en diago) sont aussi de la même couleur, c'est gagné
                        gagnant = true; 
                        return gagnant;//On retourne true
                    }
                }
            }
        }
        return gagnant; //Sinon, on retourne false 
    }
           
     public boolean diagonaleDescendanteGagnantePourCouleur(String couleur) { //Mérhode pour savoir si on a gagné sur une diagonale descendante
        boolean gagnant = false;
        for (int i = 5; i>=3; i--) { //On part de la case haut gauche, et on descends les lignes 
            for (int j = 0; j<=4; j++) { //On commence à la colonne 0 et on se décale une par une
                if (grille[i][j].lireCouleurDuJeton() == couleur) {
                    if (grille[i-1][j+1].lireCouleurDuJeton() == couleur && grille[i-2][j+2].lireCouleurDuJeton() == couleur && grille[i-3][j+3].lireCouleurDuJeton() == couleur) {
                         //On regarde les couleurs des cases en diagonanles descendantes par rapport à notre case de base, si les 3 suivantes (en diago) sont aussi de la même couleur, c'est gagné
                        gagnant = true;
                        return gagnant; //C'est gagné
                    }
                }
            }
        }
        return gagnant; //La condition n'est respectée nul part, c'est pas gagné
    }
     
    public boolean etreGagnantePourCouleur(String couleur){ //Métohde qui résume les 4 méthodes de vérification précédentes
        if ( ligneGagnantePourCouleur (couleur) == true || colonneGagnantePourCouleur (couleur) == true || diagonaleMontanteGagnantePourCouleur (couleur) == true || diagonaleDescendanteGagnantePourCouleur (couleur) == true ) {
            //Il faut qu'au moins une des vérifications soient vraies 
            return  true ;
        }
        else {
            return  false ;
        }
    }  
    
    public void tasserColonne(int colonne) {
        for (int ligne = 5; ligne > 0; ligne--) {
            if (grille[ligne][colonne].presenceJeton() == false) { //si la case est vide
                if (grille[ligne - 1][colonne].presenceJeton() == true) {//et si sa case au dessus est pleine
                    grille[ligne][colonne].affecterJeton(grille[ligne - 1][colonne].getJetonCourant());//on prend le jeton de la case superieure et on le met dans la case traitee
                    grille[ligne - 1][colonne].supprimerJeton();//et on le supprime de la case au dessu
                }
            }
        }
    }
    
    public boolean colonneRemplie(int indColonne) { //On regarde si une colonne est remplie en rentrant son indice en paramètre
        boolean remplie =false;
        int indLigne=5;
        if (grille[indLigne][indColonne].presenceJeton()==true){ //On se place à la ligne du haut et on regarde si la colonne choisie est remplie
            remplie=true;
            return remplie; //elle est remplie, on retourne true
        } else {
            remplie =false;  
            return remplie; //Sinon on retourne false
        }
        }
    
    
    public boolean presenceTrouNoir(int i, int j){  //Permets de vérifier si il y a un trou noir dans une case de coordonnée i,j données
        if (grille[i][j].presenceTrouNoir()==true){
            return true;  //Si il y en a un, on retourne true, sinon false
        }
        else{
            return false;
        }     
    }
    
    public void placerTrouNoir(int i, int j) { //Permets de placer un trou noir dans une case de coordonnée i,j données
        grille[i][j].placerTrouNoir();
    }  
    
    public void supprimerTrouNoir(int i, int j){ //Permets de supprimer un trou noir dans une case de coordonnée i,j données
        grille[i][j].supprimerTrouNoir();
    }
    
    /////////////
    
    
    public boolean presenceDesintegrateur (int i, int j) { //Permets de regarde si il y a un désintégrateur dans une case de coordonnée i,j données
        if (grille[i][j].presenceDesintegrateur()==true){
            return true;
        }else {
            return false;                   
        }
    }
    
    public void supprimerDesintegrateur(int i, int j){ //Permets de supprimer un désintégrateur dans une case de coordonnée i,j données
        grille[i][j].supprimerTrouNoir();
    }
        
    public void placerDesintegrateur(int i, int j){ //Permets de placer un désintégrateur dans une case de coordonnée i,j données
        grille[i][j].placerDesintegrateur();
    }    
    
    ////////////
    
    public void supprimerJeton(int i, int j){ //Permets de supprimer un jeton dans une case de coordonnée i,j données
        grille[i][j].supprimerJeton();
    }
    
    public Jeton recupererJeton(int i, int j){ //Permets de récupérer une jeton dans une case de coordonnée i,j données, c'est àa dire qu'il sera supprimé de la grille mais enregristré pour pouvoir être replacé
        return grille[i][j].recupererJeton();    
    }   
    
    


    
}
    

