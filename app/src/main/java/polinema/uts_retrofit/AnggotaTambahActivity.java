package polinema.uts_retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import polinema.uts_retrofit.Model.PostPutDelAnggota;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnggotaTambahActivity extends AppCompatActivity {

    EditText edtId, edtNama, edtAlamat, edtNomor;
    CardView cvSubmit;
    ApiInterface mApiInterface;
    ProgressDialog pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_tambah);

        edtId = (EditText) findViewById(R.id.txtTambahIdAnggota);
        edtNama = (EditText) findViewById(R.id.txtTambahNamaAnggota);
        edtAlamat = (EditText) findViewById(R.id.txtTambahAlamatAnggota);
        edtNomor = (EditText) findViewById(R.id.txtTambahNomorAnggota);
        cvSubmit = (CardView) findViewById(R.id.cvTambahDataAnggota);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        cvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelAnggota> postAnggotaCall = mApiInterface.postAnggota(edtId.getText().toString(), edtNama.getText().toString(), edtAlamat.getText().toString(), edtNomor.getText().toString());
                postAnggotaCall.enqueue(new Callback<PostPutDelAnggota>() {
                    @Override
                    public void onResponse(Call<PostPutDelAnggota> call, Response<PostPutDelAnggota> response) {

                        if (response.isSuccessful()){
                            Intent i = new Intent(AnggotaTambahActivity.this, AnggotaActivity.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(AnggotaTambahActivity.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AnggotaTambahActivity.this, "Gagal menambahkan data", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<PostPutDelAnggota> call, Throwable t) {
                        Toast.makeText(AnggotaTambahActivity.this, "Harap periksa koneksi anda", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
