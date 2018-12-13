package markbecker.theragbraitrail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Town3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town3);
        Intent i = getIntent();
        final GlobalVariables currentPlayer= (GlobalVariables)i.getSerializableExtra("player");

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Town3.this, BuySupplies.class);
                intent.putExtra("player", currentPlayer);
                startActivity(intent);
            }
        });
    }
}
