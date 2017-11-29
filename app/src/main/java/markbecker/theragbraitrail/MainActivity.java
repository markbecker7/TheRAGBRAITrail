package markbecker.theragbraitrail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton travelTheTrail = (RadioButton) findViewById(R.id.travel);
        final RadioButton learnAboutTrail = (RadioButton) findViewById(R.id.learn);
        final RadioButton credits = (RadioButton) findViewById(R.id.end);
        Button homeScreenButton = (Button) findViewById(R.id.HomeScreenButton);
        homeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (learnAboutTrail.isChecked()){
                    Intent intent = new Intent(MainActivity.this, LearnAboutTheTrail.class);
                    startActivity(intent);
                } else if (credits.isChecked()){
                    Intent intent = new Intent(MainActivity.this, Credits.class);
                    startActivity(intent);
                } else{
                    Intent intent = new Intent(MainActivity.this, ChooseDifficulty.class);
                    startActivity(intent);
                }
            }
        });

    }
}
