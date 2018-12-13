package markbecker.theragbraitrail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class BuySupplies extends AppCompatActivity {

    int foodPrice = 1;
    int helmetPrice = 30;
    int sparePartsPrice = 50;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_supplies);
        final EditText quantityEntered = (EditText)findViewById(R.id.quantity);
        Intent i = getIntent();
        final GlobalVariables currentPlayer= (GlobalVariables)i.getSerializableExtra("player");

        TextView currentMoney = (TextView)findViewById(R.id.currentMoney);
        TextView currentEnergy = (TextView)findViewById(R.id.currentEnergy);
        TextView currentHelmetSupply = (TextView)findViewById(R.id.currentHelmetSupply);
        TextView currentSparePartSupply = (TextView)findViewById(R.id.currentSparePartSupply);
        currentMoney.setText(currentPlayer.getMoney() + "");
        currentEnergy.setText(currentPlayer.getEnergy() + "");
        currentHelmetSupply.setText(currentPlayer.getHelmet() + "");
        currentSparePartSupply.setText(currentPlayer.getSpareParts() + "");


        Button learnAboutSupplies = (Button)findViewById(R.id.learnAboutProductsButton);
        learnAboutSupplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuySupplies.this, LearnAboutProducts.class);
                startActivity(intent);
            }
        });

        final RadioButton buyFood = (RadioButton)findViewById(R.id.buyFood);
        final RadioButton buyHelmet = (RadioButton)findViewById(R.id.buyHelmet);
        RadioButton buySparePart = (RadioButton)findViewById(R.id.buySparePart);
        Button buySupplies = (Button)findViewById(R.id.buySuppliesButton);
        buySupplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buyFood.isChecked() && !quantityEntered.getText().toString().equals("")){
                    int quantity = Integer.parseInt(quantityEntered.getText().toString());
                    value = quantity * foodPrice;
                    if(value <= currentPlayer.getMoney()) {
                        currentPlayer.subtractMoney(value);
                        currentPlayer.addEnergy(value);
                    } else {
                        Toast.makeText(getApplicationContext(), "You do not have enough money", Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(BuySupplies.this, BuySupplies.class);
                    intent.putExtra("player", currentPlayer);
                    startActivity(intent);

                } else if(buyHelmet.isChecked() && !quantityEntered.getText().toString().equals("")){
                    int quantity = Integer.parseInt(quantityEntered.getText().toString());
                    value = quantity * helmetPrice;
                    if(value <= currentPlayer.getMoney()) {
                        currentPlayer.subtractMoney(value);
                        currentPlayer.addHelmet(quantity);
                    } else {
                        Toast.makeText(getApplicationContext(), "You do not have enough money", Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(BuySupplies.this, BuySupplies.class);
                    intent.putExtra("player", currentPlayer);
                    startActivity(intent);

                } else if (!quantityEntered.getText().toString().equals("")){
                    int quantity = Integer.parseInt(quantityEntered.getText().toString());
                    value = quantity * sparePartsPrice;
                    if(value <= currentPlayer.getMoney()) {
                        currentPlayer.subtractMoney(value);
                        currentPlayer.addSparePart(quantity);
                    } else {
                        Toast.makeText(getApplicationContext(), "You do not have enough money", Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(BuySupplies.this, BuySupplies.class);
                    intent.putExtra("player", currentPlayer);
                    startActivity(intent);
                }
            }
        });

        Button travelTheTrail = (Button)findViewById(R.id.continueButton);
        travelTheTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuySupplies.this, Gameplay.class);
                intent.putExtra("player", currentPlayer);
                startActivity(intent);
            }
        });
    }
}
