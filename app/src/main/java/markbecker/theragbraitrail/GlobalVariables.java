package markbecker.theragbraitrail;

import android.app.Application;
import android.content.Context;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by mark.becker on 11/3/17.
 */


public class GlobalVariables extends Application implements Serializable {

    public int money;
    public int energy;
    public int distance;
    public String name;
    public int helmet;
    int spareParts;
    int distanceTraveled;

    public GlobalVariables(){
        money = 0;
        energy = 0;
        distance = 420;
        name = "";
        helmet = 0;
        spareParts = 0;
        distanceTraveled = 0;
    }

//Name Functions
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
//Money Functions
    public void subtractMoney(int value){
        if(value <= money) {
            money -= value;
        } else {
            Toast.makeText(getApplicationContext(), "You do not have enough money", Toast.LENGTH_LONG).show();
        }
    }

    public void setMoney(int value){
        money = value;
    }
    public int getMoney(){return money;}
//Energy Functions
    public void addEnergy(int value){
        energy += value;
    }
    public void subtractEnergy(int value){
        energy -= value;
    }
    public void setEnergy(int value){
        energy = value;
    }
    public int getEnergy(){return energy;}
//Distance Functions
    public void setDistance(int value) {
        distance = value;
    }
    public void subtractDistance(int value){
        distance -= value;
    }
    public int getDistance(){return distance;}
    public int getDistanceTraveled(){return distanceTraveled;}
    public void addDistanceTraveled(){
        distanceTraveled += 10;
    }
//Helmet Functions
    public void addHelmet(int value){
        helmet += value;
    }
    public void subtractHelmet(int value){
        helmet -= value;
    }
//Spare Parts
    public void addSparePart(int value){
        spareParts += value;
    }
    public void subtractSparePart(int value){
        spareParts -= value;
    }
}
