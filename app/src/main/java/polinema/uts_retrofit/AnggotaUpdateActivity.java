package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import polinema.uts_retrofit.Model.PostPutDelAnggota;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnggotaUpdateActivity extends AppCompatActivity {

    TextView edtId, edtNama, edtAlamat, edtNomor;
    CardView btnSubmit;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_update);

        edtId = (TextView) findViewById(R.id.txtUpdateIdAnggota);
        edtNama = (TextView) findViewById(R.id.txtUpdateNamaAnggota);
        edtAlamat = (TextView) findViewById(R.id.txtUpdateAlamatAnggota);
        edtNomor = (TextView) findViewById(R.id.txtUpdateNomorAnggota);

        btnSubmit = (CardView) findViewById(R.id.cvUpdateAnggota);

        Intent i = getIntent();
        edtId.setText(i.getStringExtra("id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(i.getStringExtra("nama"));
        edtAlamat.setText(i.getStringExtra("alamat"));
        edtNomor.setText(i.getStringExtra("nomor"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelAnggota> updateAnggotaCall = mApiInterface.putanggota(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtAlamat.getText().toString(),
                        edtNomor.getText().toString());

                updateAnggotaCall.enqueue(new Callback<PostPutDelAnggota>() {
                    @Override
                    public void onResponse(Call<PostPutDelAnggota> call, Response<PostPutDelAnggota> response) {
                        Intent i = new Intent(AnggotaUpdateActivity.this, AnggotaActivity.class);
                        startActivity(i);
                        Toast.makeText(AnggotaUpdateActivity.this,"Data berhasil diupdate",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelAnggota> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



    }
}
