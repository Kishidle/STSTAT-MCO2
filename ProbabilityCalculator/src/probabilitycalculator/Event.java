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
    
    public Event(String name, float n, float bigN, String dependentOn){
        this.name = name;
        this.n = n;
        this.bigN = bigN;
        this.dependentOn = dependentOn;
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
