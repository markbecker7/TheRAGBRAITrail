package markbecker.theragbraitrail;

import android.app.Application;
import android.content.Context;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

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
    int stopNumber;


    public GlobalVariables() {
        money = 0;
        energy = 0;
        distance = 420;
        name = "";
        helmet = 0;
        spareParts = 0;
        distanceTraveled = 0;
        stopNumber = 0;
    }

    //Name Functions
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Money Functions
    public void subtractMoney(int value) {
        if (value <= money) {
            money -= value;
        } else {
            Toast.makeText(getApplicationContext(), "You do not have enough money", Toast.LENGTH_LONG).show();
        }
    }

    public void setMoney(int value) {
        money = value;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int value){
        money += value;
    }

    //Energy Functions
    public void addEnergy(int value) {
        energy += value;
    }

    public void subtractEnergy(int value) {
        energy -= value;
    }

    public void setEnergy(int value) {
        energy = value;
    }

    public int getEnergy() {
        return energy;
    }

    //Distance Functions
    public void setDistance(int value) {
        distance = value;
    }

    public void subtractDistance(int value) {
        distance -= value;
    }

    public int getDistance() {
        return distance;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void addDistanceTraveled() {
        distanceTraveled += 10;
    }

    //Helmet Functions
    public void addHelmet(int value) {
        helmet += value;
    }

    public void subtractHelmet(int value) {
        helmet -= value;
    }

    public int getHelmet(){
        return helmet;
    }

    //Spare Parts
    public void addSparePart(int value) {
        spareParts += value;
    }

    public void subtractSparePart(int value) {
        spareParts -= value;
    }

    public int getSpareParts(){
        return spareParts;
    }

    //Stop Number
    public void addStopNumber() {
        stopNumber += 1;
    }
    public int getStopNumber(){
        return stopNumber;
    }

    public String[] listOfPossibleSituations = {"You have too much to drink and ride into a ditch. Lose one helmet and spare part.", //0
            "You slip on loose gravel while making a turn. Lose one helmet and spare part.", //1
            "You get distracted by the good-looking person next to you and crash. Lose one helmet and spare part.", //2
            "A storm comes through and blows away some of your possessions. Lose one helmet and spare part.", //3
            "You accidentally run into a parked car. Lose one helmet and spare part.", //4
            "A trick you attempt to impress your friends with goes horribly wrong. Lose one helmet and spare part.", //5
            "You lend to a person in need. Lose one helmet and spare part.", //6
            "You leave some possessions at a rest stop. Lose one helmet and spare part.", //7
            "You run over a banana peel and crash. Lose one helmet and spare part.", //8
            "You freak out after a bee lands on your arm and crash. Lose one helmet and spare part.", //9
            "You find an unopened granola bar on the side of the road. Gain 25 energy.", //10
            "A friend gives you a candy bar. Gain 25 energy.", //11
            "A friend gives you a pep talk. Gain 25 energy.", //12
            "You take a quick power nap at a kind old lady's house. Gain 25 energy.", //13
            "A church hands out free water. Gain 25 energy.", //14
            "Strangers along the trail cheer you on. Gain 25 energy.", //15
            "You spot a random hammock in the woods along the trail. Gain 25 energy.", //16
            "You coast down an extremely long hill. Gain 25 energy.", //17
            "You have a strong wind at your back. Gain 25 energy.", //18
            "You cool off by a lake. Gain 25 energy.", //19
            "You find cash on the side of the road. Gain $25.", //20
            "A friend pays you for helping him fix his bike. Gain $25.", //21
            "You find cash in your shorts pocket. Gain $25.", //22
            "You get a refund for cans in a busy recycling bin. Gain $25.", //23
            "You help an old man mow his lawn along the trail. Gain $25.", //24
            "You win a drawing. Gain $25.", //25
            "A stranger pays you for helping him change a tire. Gain $25.", //26
            "You help a stranger wash their bike. Gain $25.", //27
            "You find cash under a bench. Gain $25.", //28
            "A stranger spills coffee on their shirt and you sell them an extra one. Gain $25.", //29
            "You run over a nail. Lose one spare part.", //30
            "A screw comes lose on your handlebar. Lose one spare part.", //31
            "You find a leak in your tire. Lose one spare part.", //32
            "As you go up a steep hill your chain breaks. Lose one spare part.", //33
            "You forget some supplies after taking a short rest. Lose one spare part.", //34
            "Your friend tries to ride on your handlebars and you crash. Lose one spare part.", //35
            "You give a spare part to a stranger in need. Lose one spare part.", //36
            "You replace your seat because it hurts your butt. Lose one spare part.", //37
            "Your tire unexpectedly explodes and bursts into flames. Lose one spare part.", //38
            "Your water bottle holder breaks. Lose one spare part.", //39
            "You lend to a stranger in need. Lose one helmet.", //40
            "You attempt a burnout and pathetically fail. Lose one helmet.", //41
            "You trip on your shoelace. Lose one helmet.", //42
            "You crash over a rumble strip. Lose one helmet.", //43
            "You get angry at your friend and throw your helmet. Lose one helmet.", //44
            "You trip getting off your bike and hit your head. Lose one helmet.", //45
            "You give your helmet to a friend because he likes the style. Lose one helmet.", //46
            "You find a skate park and fail when using the ramps. Lose one helmet.", //47
            "You forget a helmet at a rest area. Lose one helmet.", //48
            "You left your helmet while stopping to get food. Lose one helmet.", //49
            "You bike against a breeze. Lose 25 energy.", //50
            "You bike up a small hill. Lose 25 energy.", //51
            "You miss your afternoon nap. Lose 25 energy.", //52
            "You eat too many sweets. Lose 25 energy.", //53
            "You are in a bad mood. Lose 25 energy.", //54
            "You forget to pump up your tires all the way. Lose 25 energy.", //55
            "You spend too much time admiring the Iowa countryside and have to catch up. Lose 25 energy.", //56
            "You carry someone else's gear for them. Lose 25 energy.", //57
            "You realize you did not train hard enough for this biking journey. Lose 25 energy.", //58
            "You bike without shade for a long time. Lose 25 energy.", //59
            "You bike against a strong wind. Lose 50 energy.", //60
            "You bike up a long hill. Lose 50 energy.", //61
            "You don't get enough sleep. Lose 50 energy.", //62
            "You eat way too much for lunch. Lose 50 energy.", //63
            "Your nagging friend calls your cell phone. Lose 50 energy.", //64
            "You drink too much. Lose 50 energy.", //65
            "You bike up a steep hill. Lose 50 energy.", //66
            "You forget your morning coffee. Lose 50 energy.", //67
            "You get a nasty cold. Lose 50 energy.", //68
            "A crying kid in a nearby tent keeps you up all night. Lose 50 energy.", //69
            "You buy some medicine for your muscle soreness. Lose $25.", //70
            "You buy a lot of sweetcorn. Lose $25.", //71
            "You buy a cushion for your bike seat. Lose $25.", //72
            "You eat out. Lose $25.", //73
            "You buy lottery tickets for your friends. Lose $25.", //74
            "You go grocery shopping. Lose $25.", //75
            "You buy a patch for the hole in your tent. Lose $25.", //76
            "You donate to a local charity. Lose $25.", //77
            "You misplace some cash. Lose $25.", //78
            "You buy a nice new pair of socks. Lose $25.", //79
            "You drop your wallet. Lose $50.", //80
            "You spend way too much on beer. Lose $50.", //81
            "You can't help but buy something from every general store. Lose $50.", //71
            "You buy a souvenir. Lose $50.", //82
            "You lend some money to a friend. Lose $50.", //83
            "You eat at an expensive restaurant. Lose $50.", //84
            "You buy a new tent for the night. Lose $50.", //85
            "You buy the drinks for your group. Lose $50.", //86
            "You buy a painting of the beautiful Iowa countryside. Lose $50.", //87
            "You stop at a casino and don't do so good. Lose $50.", //88
            "You buy a concert ticket for the night. Lose $50." //89

    };
}
