package markbecker.theragbraitrail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YouWin extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);
        Intent i = getIntent();
        final GlobalVariables currentPlayer= (GlobalVariables)i.getSerializableExtra("player");
        TextView playerName = (TextView)findViewById(R.id.playerName);
        playerName.setText(currentPlayer.getName());

        Button tryAgain = (Button)findViewById(R.id.btnPlayAgain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouWin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
