package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import polinema.uts_retrofit.Model.PostPutDelAnggota;
import polinema.uts_retrofit.Model.PostPutDelBuku;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuDetailActivity extends AppCompatActivity {

    CardView btnUpdate, btnDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_detail);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String nama = i.getStringExtra("nama");
        String penulis= i.getStringExtra("penulis");
        String penerbit = i.getStringExtra("penerbit");

        final TextView txtId = (TextView) findViewById(R.id.txtIdBuku);
        final TextView txtNama = (TextView) findViewById(R.id.txtNamaBuku);
        final TextView txtPenulis = (TextView) findViewById(R.id.txtPenulisBuku);
        final TextView txtPenerbit = (TextView) findViewById(R.id.txtPenerbitBuku);

        btnUpdate = (CardView) findViewById(R.id.cvUpdateDataBuku);
        btnDelete = (CardView) findViewById(R.id.cvDeleteDataBuku);

        txtId.setText(id);
        txtNama.setText(nama);
        txtPenulis.setText(penulis);
        txtPenerbit.setText(penerbit);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BukuDetailActivity.this, BukuUpdateActivity.class);
                i.putExtra("id",txtId.getText().toString());
                i.putExtra("nama",txtNama.getText().toString());
                i.putExtra("penulis",txtPenulis.getText().toString());
                i.putExtra("penerbit",txtPenerbit.getText().toString());
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelBuku> deleteBuku = mApiInterface.deleteBuku(txtId.getText().toString());
                    deleteBuku.enqueue(new Callback<PostPutDelBuku>() {
                        @Override
                        public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
                            if (response.isSuccessful()){
                                Intent i = new Intent(BukuDetailActivity.this, BukuActivity.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(BukuDetailActivity.this, "Berhasil menghapus data", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(AnggotaDetailActivity.this, txtId.getText().toString(), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(BukuDetailActivity.this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
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
