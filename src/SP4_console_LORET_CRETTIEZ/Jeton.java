/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LORET_CRETTIEZ;

/**
 *
 * @author benja
 */
public class Jeton {
    private String couleur; //Déclaration de l'attribut couleur (type String)
    public Jeton (String color) {
        couleur = color; //L'attribut prend la valeur du paramètre color
    }
    
   
    public String lireCouleur () {
        return couleur; //Retourne la valeur de couleur
    }
    
    
    @Override
    public String toString() {
        String retourner = null; //Déclaration de la variable retourner, initialisation à null
        if (couleur == "rouge") {
            retourner = "R"; //Si le jeton est rouge, retourner prend la valeur "R"
        } else if (couleur == "jaune") {
            retourner = "J"; //Si la jeton est jaune, retourner prend la valeur "J"
        }
        return retourner; //Retourne la variable
    }
}
