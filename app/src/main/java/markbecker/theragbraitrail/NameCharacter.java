package markbecker.theragbraitrail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.io.Serializable;

public class NameCharacter extends AppCompatActivity {

    String nameEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_character);

        final EditText nameField = (EditText)findViewById(R.id.name);
        final Button setName = (Button)findViewById(R.id.buttonGoName);

        setName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEntered = nameField.getText().toString();
                Intent i = getIntent();
                GlobalVariables currentPlayer= (GlobalVariables)i.getSerializableExtra("player");
                currentPlayer.setName(nameEntered);
                Intent intent = new Intent(NameCharacter.this, Town1.class);
                intent.putExtra("player", currentPlayer);
                startActivity(intent);

            }
        });
    }
}
