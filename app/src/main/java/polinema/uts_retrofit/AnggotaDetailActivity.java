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


public class AnggotaDetailActivity extends AppCompatActivity {

    CardView btnUpdate, btnDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_detail);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        //Mengambil data yang diumpankan dari activity sebelumnya, yaitu AnggotaAdapter
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String nama = i.getStringExtra("nama");
        String alamat= i.getStringExtra("alamat");
        String notelp = i.getStringExtra("notelp");

        final TextView txtId = (TextView) findViewById(R.id.txtIdAnggota);
        final TextView txtNama = (TextView) findViewById(R.id.txtNamaAnggota);
        final TextView txtAlamat = (TextView) findViewById(R.id.txtAlamatAnggota);
        final TextView txtNoTelp = (TextView) findViewById(R.id.txtNomorTeleponAnggota);

        btnUpdate = (CardView) findViewById(R.id.cvUpdateDataAnggota);
        btnDelete = (CardView) findViewById(R.id.cvDeleteDataAnggota);

        txtId.setText(id);
        txtNama.setText(nama);
        txtAlamat.setText(alamat);
        txtNoTelp.setText(notelp);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaDetailActivity.this, AnggotaUpdateActivity.class);
                i.putExtra("id",txtId.getText().toString());
                i.putExtra("nama",txtNama.getText().toString());
                i.putExtra("alamat",txtAlamat.getText().toString());
                i.putExtra("nomor",txtNoTelp.getText().toString());
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelAnggota> deleteAnggota = mApiInterface.deleteAnggota(txtId.getText().toString());
                    deleteAnggota.enqueue(new Callback<PostPutDelAnggota>() {
                        @Override
                        public void onResponse(Call<PostPutDelAnggota> call, Response<PostPutDelAnggota> response) {
                            if (response.isSuccessful()){
                                Intent i = new Intent(AnggotaDetailActivity.this, AnggotaActivity.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(AnggotaDetailActivity.this, "Berhasil menghapus data", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(AnggotaDetailActivity.this, txtId.getText().toString(), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(AnggotaDetailActivity.this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<PostPutDelAnggota> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Harap periksa koneksi anda", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
