package polinema.uts_retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import polinema.uts_retrofit.Adapter.PeminjamanAdapter;
import polinema.uts_retrofit.Model.GetPeminjaman;
import polinema.uts_retrofit.Model.Peminjaman;
import polinema.uts_retrofit.R;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeminjamanActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peminjaman);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvPeminjaman);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

       getPeminjaman();

    }

    private void getPeminjaman() {

        progressDialog = ProgressDialog.show(this, "Data Peminjaman" ,"Memuat Data ...", true, false);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<GetPeminjaman> peminjamanCall = mApiInterface.getPeminjaman();
        peminjamanCall.enqueue(new Callback<GetPeminjaman>() {
            @Override
            public void onResponse(Call<GetPeminjaman> call, Response<GetPeminjaman> response) {

                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    List<Peminjaman> peminjamanList = response.body().getListDataPeminjamen();
                    Log.d("Retrofit Get", "Jumlah data pembelian: " +
                            String.valueOf(peminjamanList.size()));
                    mAdapter = new PeminjamanAdapter(peminjamanList);
                    mRecyclerView.setAdapter(mAdapter);
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(PeminjamanActivity.this, "Gagal mengambil data Peminjaman", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetPeminjaman> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(PeminjamanActivity.this, "Tidak dapat menyambungkan, cek kembali koneksi anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
