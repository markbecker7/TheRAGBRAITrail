package markbecker.theragbraitrail;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ChooseDifficulty extends AppCompatActivity {

    GlobalVariables player = new GlobalVariables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_difficulty);
        final RadioButton college = (RadioButton) findViewById(R.id.characterChoiceCollege);
        final RadioButton accountant = (RadioButton) findViewById(R.id.characterChoiceAccountant);
        final RadioButton retired = (RadioButton) findViewById(R.id.characterChoiceRetired);
        final RadioButton findTheDifference = (RadioButton) findViewById(R.id.whatsTheDifference);
        Button chooseCharacterButton = (Button) findViewById(R.id.buttonPickCharacter);


        chooseCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (college.isChecked()){
                    player.setMoney(250);
                    player.setEnergy(750);
                    Intent intent = new Intent(ChooseDifficulty.this, NameCharacter.class);
                    intent.putExtra("player", player);
                    startActivity(intent);


                } else if (accountant.isChecked()){
                    player.setMoney(500);
                    player.setEnergy(500);
                    Intent intent = new Intent(ChooseDifficulty.this, NameCharacter.class);
                    intent.putExtra("player", player);
                    startActivity(intent);

                } else if (retired.isChecked()){
                    player.setMoney(750);
                    player.setEnergy(250);
                    Intent intent = new Intent(ChooseDifficulty.this, NameCharacter.class);
                    intent.putExtra("player", player);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(ChooseDifficulty.this, TheDifferenceBetweenCharacters.class);
                    startActivity(intent);
                }
            }
        });

    }
}
