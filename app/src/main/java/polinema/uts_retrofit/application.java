package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class application extends AppCompatActivity {

    Button btMaps;
//    CardView Maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        btMaps = (Button) findViewById(R.id.btMaps);


        btMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(application.this, MapsActivity.class);
                application.this.startActivity(i);
            }
        });
    }
}
