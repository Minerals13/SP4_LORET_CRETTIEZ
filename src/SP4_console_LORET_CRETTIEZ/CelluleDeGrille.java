/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author benja
 */
public class CelluleDeGrille {
    private Jeton jetonCourant; //Déclaration de l'attribut jetonCourant (type Jeton)
    private boolean avoirTrouNoir; //Déclaration de l'attribut avoirTrouNoir (type boolean)
    private boolean avoirDesintegrateur; //Déclaration de l'attribut avoirDesintegrateur (type boolean)
    
    
    public CelluleDeGrille () { //Constructeur
       this.jetonCourant = null; //initialisation de l'attribut avec comme valeur par défaut : null
       this.avoirTrouNoir = false; //initialisation de l'attribut avec comme valeur par défaut : false
       this.avoirDesintegrateur = false; //initialisation de l'attribut avec comme valeur par défaut : false
    }
   
    
    public boolean presenceJeton () {
        boolean retour; //variable temporaire de type boolean
        if ((jetonCourant.lireCouleur() == "rouge") || (jetonCourant.lireCouleur() == "jaune")) {
           retour = true; //Si il y a un jeton, retour prend la valeur true 
        } else {
        retour = false; //Si il n'y a pas de jeton, retour prend la valeur false
        }
    return retour; //retroune la variable 
    }
    
    
   public void affecterJeton (Jeton jetCour) {
       jetonCourant = jetCour; //affecte la valeur de jetCour à jetonCourant pour l'ajouter en paramètre de la cellule
   }
   
   
   public String lireCouleurDuJeton () {
       if (jetonCourant != null) {
           return jetonCourant.lireCouleur(); //Si jetonCourant n'est pas null, retourne la couleur de jetonCourant 
       } else {
           return "vide"; //Si jetonCourant n'a pas de valeur, retourne false
       }
       
   }
   
   
   @Override
    public String toString() {
        String retourner; //Variable temporaire de type String
        if (jetonCourant.lireCouleur() == "rouge") {
        retourner = "R"; //Si jetonCourant est rouge, retourner prend la valeur "R"
        } else if (jetonCourant.lireCouleur() == "jaune") {
            retourner = "J"; //Si jetonCourant est jaune, retourner prend la valeur "J"
        }else if (presenceDesintegrateur () == true) {
            retourner = "D";
        } else if (presenceTrouNoir() == true) {
            retourner = "@";
        } else {
            retourner = "."; //Si il n'y a pas de couleur, il n'y a pas de jeton, donc retourner prend la valeur "."
        }
        return retourner; //Renvoie la variable retourner
    }
    
    
    public Jeton recupererJeton () {
        Jeton temp; //variable temporaire de type Jeton
        temp = jetonCourant; //La variable prend la valeur de jetonCourant
        jetonCourant = null; //jetonCourant prend la valeur null
        return temp; //retourne la variable, donc l'ancienne valeur de jetonCourant
    }
    
    
    public void placerTrouNoir () {
        avoirTrouNoir = true; //La valeur d'avoirTrouNoir devient true
    }
    
    
    public void supprimerTrouNoir () {
        avoirTrouNoir = false; //La valeur d'avoirTrouNoir devient false
    }
    
    
    public boolean presenceTrouNoir () {
        if (avoirTrouNoir == true) {
            return true; //Si avoirTrouNoir est égal à true, renvoie true, il y a donc un trou noir
        } else {
            return false; //Si avoirTrouNoir est égal à false, renvoie false, il n'y a donc pas de trou noir
        }
    }
    
    
    public void supprimerJeton () {
        jetonCourant = null; //La valeur de jetonCourant devient null, il n'ya donc plus de jetonCourant
    }
    
    
    public void activerTrouNoir () {
        supprimerJeton(); //Supprime le jeton de la cellule
        supprimerTrouNoir(); //Supprime le trou noir de la cellule
    }
    
    
    public boolean presenceDesintegrateur () {
        if (avoirDesintegrateur == true) {
            return true; //Si il y a un desintegrateur, renvoie true
        } else {
            return false; //Si il n'y en a pas, renvoie false
        }
    }
    
    
    public void placerDesintegrateur () {
        avoirDesintegrateur = true; //avoirDesintegrateur prend la valeur true, la cellule contient alors un desintegrateur
    }
    
    
    public void supprimerDesintegrateur () {
        avoirDesintegrateur = false; //avoirDesintegrateur prend la valeur false, il n'y a plus de desintegrateur dans la cellule
    }
    
    
    public void activerDesintegrateur () {
        supprimerJeton(); //Supprime le jeton de la cellule
        supprimerDesintegrateur(); //Supprime le desintegrateur de la cellule
    }

}

