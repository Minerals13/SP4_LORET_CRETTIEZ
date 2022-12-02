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
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    public void CelluleDeGrille () {
       this.jetonCourant = null;
    }
   
    public boolean presenceJeton () {
        boolean retour;
        if ((jetonCourant.lireCouleur() == "rouge") || (jetonCourant.lireCouleur() == "jaune")) {
           retour = true;
        } else {
        retour = false;
        }
    return retour;
    }
    
   public void affecterJeton (Jeton jetCour) {
       this.jetonCourant = jetCour;
   }
   
   public String lireCouleurDuJeton () {
       if (jetonCourant != null) {
           return jetonCourant.lireCouleur();
       } else {
           return "vide";
       }
       
   }
   
   @Override
    public String toString() {
        String retourner;
        if (jetonCourant.lireCouleur() == "rouge") {
        retourner = "R";
        } else if (jetonCourant.lireCouleur() == "jaune") {
            retourner = "J";
        } else {
            retourner = ".";
        }
        return retourner;
    }
    
    public String recupererJeton () {
        String temp;
        temp = jetonCourant.lireCouleur();
        jetonCourant = null;
        return temp;
    }
    
    public void placerTrouNoir () {
        avoirTrouNoir = true;
    }
    
    public void supprimerTrouNoir () {
        avoirTrouNoir = false;
    }
    
    public boolean presenceTrouNoir () {
        if (avoirTrouNoir == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public void supprimerJeton () {
        
    }
}

