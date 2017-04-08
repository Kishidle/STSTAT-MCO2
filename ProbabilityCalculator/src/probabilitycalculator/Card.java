/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilitycalculator;

/**
 *
 * @author Sai
 */
public class Card {

    
    public Card(String name, String type, String rarity, int cost, int num, boolean animated){
        
       this.name = name;
       this.type = type;
       this.rarity = rarity;
       this.cost = cost;
       this.numberOf = num;
       this.animated = animated;
        
    }
    /**
     * @return the animated
     */
    public boolean isAnimated() {
        return animated;
    }

    /**
     * @param animated the animated to set
     */
    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the rarity
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * @param rarity the rarity to set
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the numberOf
     */
    public int getNumberOf() {
        return numberOf;
    }

    /**
     * @param numberOf the numberOf to set
     */
    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }
    
    private String name;
    private String type;
    private String rarity;
    private int cost;
    private int numberOf;
    private boolean animated;
}
