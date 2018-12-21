package markbecker.theragbraitrail;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Console;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Gameplay extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    AnimationDrawable bikeAnimation;
    int[] stopDistances = {30,60,100,140,170,200,230,260,290,320,350,380,400,420};
    int[] stopDistanceIntervals = {30,30,40,40,30,30,30,30,30,30,30,30,20,20};
    Random rand = new Random();
    int randomNumber;
    CountDownTimer cdTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        Intent i = getIntent();
        final GlobalVariables currentPlayer= (GlobalVariables)i.getSerializableExtra("player");

        ImageView animationFrame = (ImageView)findViewById(R.id.animationSet);
        animationFrame.setBackgroundResource(R.drawable.animation);
        bikeAnimation = (AnimationDrawable)animationFrame.getBackground();
        bikeAnimation.start();

        final TextView viewEnergy = (TextView)findViewById(R.id.valueEnergy);
        final TextView viewDistanceTraveled = (TextView)findViewById(R.id.valueDistanceTraveled);
        final TextView viewDistanceNextStop = (TextView)findViewById(R.id.valueDistanceOfNextStop);
        final TextView viewRemainingDistance = (TextView)findViewById(R.id.valueRemainingDistance);

        viewEnergy.setText(currentPlayer.getEnergy() + "");
        viewDistanceTraveled.setText(currentPlayer.getDistanceTraveled() + "");
        viewDistanceNextStop.setText(stopDistances[currentPlayer.getStopNumber()] + "");
        viewRemainingDistance.setText((currentPlayer.getDistance() - currentPlayer.getDistanceTraveled()) + "");

        new CountDownTimer(stopDistanceIntervals[currentPlayer.getStopNumber()] * 320, 3200){
            public void onTick(long l){
                viewEnergy.setText(currentPlayer.getEnergy() + "");
                viewDistanceTraveled.setText(currentPlayer.getDistanceTraveled() + "");
                viewDistanceNextStop.setText(stopDistances[currentPlayer.getStopNumber()] + "");
                viewRemainingDistance.setText((currentPlayer.getDistance() - currentPlayer.getDistanceTraveled()) + "");
                currentPlayer.subtractEnergy(20);
                currentPlayer.addDistanceTraveled();

                randomNumber = rand.nextInt(300);

                if(randomNumber <= 89){
                    if(randomNumber >= 80){
                        if(currentPlayer.getMoney() >= 50){
                            currentPlayer.subtractMoney(50);
                            Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();
                        }
                    } else if(randomNumber >=70){
                        if(currentPlayer.getMoney() >= 25){
                            currentPlayer.subtractMoney(25);
                            Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();
                        }
                    } else if(randomNumber >=60){
                        currentPlayer.subtractEnergy(50);
                        Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();

                    } else if(randomNumber >=50){
                        currentPlayer.subtractEnergy(25);
                        Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();

                    } else if(randomNumber >=40){
                        currentPlayer.subtractHelmet(1);
                        if(currentPlayer.getHelmet() >= 0){
                            Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You don't have a helmet and you crashed!", Toast.LENGTH_LONG).show();
                            cancel();
                            Intent intent = new Intent(Gameplay.this, YouLose.class);
                            intent.putExtra("player", currentPlayer);
                            startActivity(intent);
                        }

                    } else if(randomNumber >=30){
                        currentPlayer.subtractSparePart(1);
                        if(currentPlayer.getSpareParts() >= 0){
                            Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You needed a spare part but don't have one!", Toast.LENGTH_LONG).show();
                            cancel();
                            Intent intent = new Intent(Gameplay.this, YouLose.class);
                            intent.putExtra("player", currentPlayer);
                            startActivity(intent);
                        }

                    } else if(randomNumber >=20){
                        currentPlayer.addMoney(25);
                        Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();

                    } else if(randomNumber >=10){
                        currentPlayer.addEnergy(25);
                        Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();

                    } else {
                        if(currentPlayer.getHelmet() >= 0 && currentPlayer.getSpareParts() >= 0){
                            currentPlayer.subtractHelmet(1);
                            currentPlayer.subtractSparePart(1);
                            Toast.makeText(getApplicationContext(), currentPlayer.listOfPossibleSituations[randomNumber], Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You needed a spare part and helmet but don't have both of them!", Toast.LENGTH_LONG).show();
                            cancel();
                            Intent intent = new Intent(Gameplay.this, YouLose.class);
                            intent.putExtra("player", currentPlayer);
                            startActivity(intent);
                        }

                    }
                }

                if (currentPlayer.getEnergy() <= 0){
                    cancel();
                    Intent intent = new Intent(Gameplay.this, YouLose.class);
                    intent.putExtra("player", currentPlayer);
                    startActivity(intent);
                }
            }
            public void onFinish(){
                if(currentPlayer.getStopNumber() % 2 != 0) {
                    if(currentPlayer.getStopNumber() == 1){
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town2.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else if(currentPlayer.getStopNumber() == 3){
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town3.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else if(currentPlayer.getStopNumber() == 5) {
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town4.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else if(currentPlayer.getStopNumber() == 7) {
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town5.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else if(currentPlayer.getStopNumber() == 9) {
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town6.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else if(currentPlayer.getStopNumber() == 11) {
                        currentPlayer.addStopNumber();
                        Intent intent = new Intent(Gameplay.this, Town7.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Gameplay.this, Town8.class);
                        intent.putExtra("player", currentPlayer);
                        startActivity(intent);
                    }
                } else {
                    currentPlayer.addStopNumber();
                    Intent intent = new Intent(Gameplay.this, BuySupplies.class);
                    intent.putExtra("player", currentPlayer);
                    startActivity(intent);
                }
            }
        }.start();

    }
}
