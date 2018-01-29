package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btAnggota, btBuku, btPeminjaman;
    CardView cvAnggota, cvBuku, cvPeminjaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvAnggota = (CardView) findViewById(R.id.cvDataAnggota);
        cvBuku = (CardView) findViewById(R.id.cvDataBuku);
        cvPeminjaman = (CardView) findViewById(R.id.cvDataPeminjaman);

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
    }
}
