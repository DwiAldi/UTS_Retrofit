package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    CardView cvAnggota, cvBuku, cvPeminjaman, application, cvLogout;
    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvAnggota = (CardView) findViewById(R.id.cvDataAnggota);
        cvBuku = (CardView) findViewById(R.id.cvDataBuku);
        cvPeminjaman = (CardView) findViewById(R.id.cvDataPeminjaman);
        cvLogout = (CardView) findViewById(R.id.cvLogout);
        application = (CardView) findViewById(R.id.application);
        txtUsername = (TextView) findViewById(R.id.textViewUsername);

        Intent i = getIntent();
        txtUsername.setText("Selamat datang kembali, "+i.getStringExtra("username"));

        cvAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AnggotaActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        cvBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BukuActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        cvPeminjaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PeminjamanActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        application.setOnClickListener (new View.OnClickListener(){
            @Override
            public  void onClick(View view) {
                Intent i = new Intent (MainActivity.this, application.class);
                MainActivity.this.startActivity(i);
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(i);
                Toast.makeText(MainActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                onDestroy();
            }
        });
    }
}
