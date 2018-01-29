package polinema.uts_retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import polinema.uts_retrofit.Adapter.BukuAdapter;
import polinema.uts_retrofit.Model.Buku;
import polinema.uts_retrofit.Model.GetBuku;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuActivity extends AppCompatActivity {

    Button btnTambah;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvBuku);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btnTambah = (Button) findViewById(R.id.btnTambahBuku);

        getBuku();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BukuActivity.this, BukuTambahActivity.class);
                startActivity(i);
            }
        });

    }

    private void getBuku() {

        progressDialog = ProgressDialog.show(this, "Data Buku", "Memuat Data ...", true,false);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<GetBuku> bukuCall = mApiInterface.getBuku();
        bukuCall.enqueue(new Callback<GetBuku>() {
            @Override
            public void onResponse(Call<GetBuku> call, Response<GetBuku> response) {
                if (response.isSuccessful()){

                    progressDialog.dismiss();

                    List<Buku> bukuList = response.body().getListDataBukue();
                    Log.d("Retrofit Get", "Jumlah data pembelian: " +
                            String.valueOf(bukuList.size()));
                    mAdapter = new BukuAdapter(bukuList, BukuActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(BukuActivity.this, "Gagal mengambil data Buku", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetBuku> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(BukuActivity.this, "Tidak dapat menyambungkan, cek kembali koneksi anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
