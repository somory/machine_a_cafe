/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineacafe;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author julien
 */
public class ManagerMachine {
    private HashMap<String,Integer> ingredients = new HashMap<String,Integer>();
    //private Boisson boissons[] = new Boisson[3];
    
    public ManagerMachine()
    {
        ingredients.put("cafe", 200);
        ingredients.put("lait", 200);
        ingredients.put("chocolat", 200);
        ingredients.put("sucre", 200);
    }
    
    /*public void ajoutBoisson (Boisson boisson)
    {
        
    }*/
    
    /**
     * getQuantiteIngredient() 
     * @param nom
     * @return 
     */
    public int getQuantiteIngredient(String nom){
        
        return ingredients.get(nom);
    }
    
    public void ajoutIngredient(String nom, Integer quantite)
    {   
        for ( String key : ingredients.keySet() ) 
        {
            if(nom.toLowerCase() != key.toLowerCase())
            {
                if(quantite > 0)
                {
                    if((quantite + getQuantiteIngredient(nom)) < 200)
                    {
                        ingredients.put(nom.toLowerCase(), quantite); 
                    }
                    else 
                    {
                        System.out.println("Quantité Overflow");
                    }
                }
                else
                {
                    System.out.println("Quantité insuffisante");
                }
            }
            else
            {
                System.out.println("Ingrédient déjà présent.");
            }
        }
    }
    
    public void getIngredients()
    {
        
        Scanner sc = new Scanner(System.in);
        
        for ( String ingredient : ingredients.keySet() ) 
        {
            System.out.println(ingredient + ": " + ingredients.get(ingredient));
        }
        
        System.out.println("");
        
        System.out.println("Press any key :");
        String anyKey = sc.nextLine();
    }
}
