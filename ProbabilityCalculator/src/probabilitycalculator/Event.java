/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilitycalculator;

/**
 *
 * @author Ramon
 */
public class Event {
    
    private String name;
    private float n;
    private float bigN;
    private String dependentOn;
    private float probability;
    private String selectedName;
    private String selectedType;
    private String selectedRarity;
    private String selectedCost;
    
    public Event(String name, float n, float bigN, String dependentOn, String selectedName, String selectedType, String selectedRarity, String selectedCost){
        this.name = name;
        this.n = n;
        this.bigN = bigN;
        this.dependentOn = dependentOn;
        this.selectedName = selectedName;
        this.selectedType = selectedType;
        this.selectedRarity = selectedRarity;
        this.selectedCost = selectedCost;
    }
    public void setSelectedName(String selectedName){
        this.selectedName = selectedName;
    }
    
    public String getSelectedName(){
        return selectedName;
    }
    
    public void setSelectedType(String selectedType){
        this.selectedType = selectedType;
    }
    
    public String getSelectedType(){
        return selectedType;
    }
    
    public void setSelectedRarity(String selectedRarity){
        this.selectedRarity = selectedRarity;
    }
    
    public String getSelectedRarity(){
        return selectedRarity;
    }
    
    public void setSelectedCost(String selectedCost){
        this.selectedCost = selectedCost;
    }
    
    public String getSelectedCost(){
        return selectedCost;
    }
    
    public void setProbability(Float probability){
        this.probability = probability;
    }
    
    public float getProbability(){
        return probability;
    }
    public void setDependent(String dependentOn){
        this.dependentOn = dependentOn;
     
    }
    public String getDependent(){
        return dependentOn;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSmallN(float n){
        this.n = n;
    }
    public float getSmallN(){
        return n;
    }
    public void setBigN(float bigN){
        this.bigN = bigN;
    }
    public float getBigN(){
        return bigN;
    }
       
}
