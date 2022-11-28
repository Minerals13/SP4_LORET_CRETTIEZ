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
    private String jetonCourant;
   
    public CelluleDeGrille () {
       
       this.jetonCourant = null;
    }
   
    public boolean presenceJeton () {
        boolean retour;
        if ((jetonCourant == "rouge") || (jetonCourant == "jaune")) {
           retour = true;
        } else {
        retour = false;
        }
    return retour;
   }
}
