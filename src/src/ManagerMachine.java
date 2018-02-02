package src;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author julien
 */
public class ManagerMachine {
    private HashMap<String,Integer> ingredients = new HashMap<String,Integer>();
    private ArrayList<Boisson> boissons = new ArrayList<Boisson>();
    
    public ManagerMachine()
    {
        ingredients.put("cafe", 200);
        ingredients.put("lait", 200);
        ingredients.put("chocolat", 200);
        ingredients.put("sucre", 200);
    }
    
    /**
     * ajoutBoisson() Ajoute une boisson dans la machine (max 3 boissons)
     * @param <String> nom, <int> prix
     * @return <Boisson> boisson
     */
    public Boisson ajoutBoisson (String nom, int prix)
    {
    		Boisson boisson = null;
    		
    		/*for()
    		{
    			
    		}*/
    		
    		if(boissons.size() < 3)
    		{
    			boisson = new Boisson(nom, prix);
    			boissons.add(boisson);
    		}
    		else
    		{
    			System.out.println("Impossible d'ajouter une boisson: Déjà trop de boisson");
    		}
    		
    		return boisson;
    }
    
    /**
     * Supprimer la boisson passée en paramètre
     * @param Boisson boisson
     */
    public void supprimerBoisson(Boisson boisson)
    {
    		boissons.remove(boisson);
    }
    
    /**
     * Getter pour boissons
     * @return ArrayList<Boisson> 
     */
    public ArrayList<Boisson> getListeBoissons() 
    {
    		return boissons;
    }
    
    /**
     * getQuantiteIngredient() 
     * @param nom
     * @return la quantité de cet ingrédient
     */
    public int getQuantiteIngredient(String nom)
    {
    		if(ingredients.containsKey(nom))
    		{
    			return ingredients.get(nom);
    		}
    		else
    		{
    			return -1;
    		}
    }
    
    /**
     * ajoutIngredient() Ajoute l'ingrédient dans le HashMap. Vérification si le nom 
     * n'est pas prix, puis la quantité
     * @param nom
     * @param quantite
     */
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
    
    /** getListeIngredients()
     *  Affiche tous les ingrédients dans la console. Puis demande d'appuyer sur une touche pour continuer
     *  @return Renvoie la liste des ingrédients
     */
    public String getListeIngredients()
    {
        
        String listeIngredients = "Ingrédient \tQuantité \n";
        
        for ( String ingredient : ingredients.keySet() ) 
        {
            listeIngredients += ingredient + "\t\t" + ingredients.get(ingredient) + "\n";
        }
        

		return listeIngredients;
    }
    
    /**
     * ajouterIngredient() ajoute un ingredient à la machine (on parle de la quantité)
     * @param ingredient
     * @param quantite
     * @return
     */
    public boolean ajouterIngredient(String ingredient, int quantite)
    {
    		boolean reponse = false;
    		
    		if(this.verifierQuantiteIngredient(ingredient, quantite))
		{
			quantite = this.getQuantiteIngredient(ingredient) + quantite;
			this.ingredients.put(ingredient, quantite);
			reponse = true;
		}
    	
    		return reponse;
    }
    
    /**
     * verifierQuantiteIngredient() Vérifie que la quantité ne dépasse pas 200
     * @param ingredient
     * @param quantite
     * @return
     */
    public boolean verifierQuantiteIngredient(String ingredient, int quantite)
    {
    		boolean reponse = false;
    		if((this.getQuantiteIngredient(ingredient) + quantite) > 200)
    		{
    			reponse = true;
    		}
    		
    		return reponse;
    }
}