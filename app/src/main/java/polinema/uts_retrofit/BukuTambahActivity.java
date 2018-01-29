package polinema.uts_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import polinema.uts_retrofit.Model.PostPutDelAnggota;
import polinema.uts_retrofit.Model.PostPutDelBuku;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuTambahActivity extends AppCompatActivity {

    EditText edtId, edtNama, edtPenulis, edtPenerbit;
    CardView cvSubmit;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_tambah);

        edtId = (EditText) findViewById(R.id.txtTambahIdBuku);
        edtNama = (EditText) findViewById(R.id.txtTambahNamaBuku);
        edtPenulis = (EditText) findViewById(R.id.txtTambahPenulisBuku);
        edtPenerbit = (EditText) findViewById(R.id.txtTambahPenerbitBuku);
        cvSubmit = (CardView) findViewById(R.id.cvTambahDataBuku);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        cvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelBuku> postBukuCall = mApiInterface.postBuku(edtId.getText().toString(), edtNama.getText().toString(), edtPenulis.getText().toString(), edtPenerbit.getText().toString());
                postBukuCall.enqueue(new Callback<PostPutDelBuku>() {
                    @Override
                    public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {

                        if (response.isSuccessful()){
                            Intent i = new Intent(BukuTambahActivity.this, BukuActivity.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(BukuTambahActivity.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(BukuTambahActivity.this, "Gagal menambahkan data", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
                        Toast.makeText(BukuTambahActivity.this, "Harap periksa koneksi anda", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
