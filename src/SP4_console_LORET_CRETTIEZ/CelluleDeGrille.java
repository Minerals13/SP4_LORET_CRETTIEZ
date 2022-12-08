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
        if (jetonCourant == null) {
            return false;
        } else {
            return true;
        }
    }
    public Jeton getJetonCourant() {
        return jetonCourant;
    }
    
    public void affecterJeton (Jeton jetCour) {
       this.jetonCourant = jetCour; //affecte la valeur de jetCour à jetonCourant pour l'ajouter en paramètre de la cellule
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
        String retourner = null; //Variable temporaire de type String
        if (jetonCourant == null) { //Lorsqu'il n'y a pas de jeton
            if (presenceDesintegrateur() == true) { //Si il y a un désintegrateur
                //Cas où le désintégrateur et le trou noir sont sur la même case
                if (presenceTrouNoir() == true) { //Et un trou noir
                    retourner = "@"; //On marque qu'il y a un trou noir
                } else {
                    retourner = "D"; //Sinon on marque qu'il y a un désintégrateur
                }
            } else if (presenceTrouNoir() == true) { //Si il y a un trou noir
                //Cas où les désintégrateurs et les trous noirs ne sont pas confondus sur une même case
                if (presenceDesintegrateur() == false) { //Et pas de désintégrateur
                    retourner = "@"; //On marque qu'il y a un trou noir
                } 
            } else {
                retourner = "."; //Si il n'y a rien sur la case 
            }  
        } else if (jetonCourant.lireCouleur() == "rouge") { //Si il y a un jeton rouge
            retourner = "R";
        } else if (jetonCourant.lireCouleur() == "jaune") { //Si il y a un jeton jaune
            retourner = "J";
        }
        return retourner;
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

