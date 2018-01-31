package polinema.uts_retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import polinema.uts_retrofit.Adapter.AnggotaAdapter;
import polinema.uts_retrofit.Model.Anggota;
import polinema.uts_retrofit.Model.GetAnggota;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldid on 1/27/2018.
 */

public class AnggotaActivity extends AppCompatActivity{
//    public static final String EXTRA_ID = "id";
//    public static final String EXTRA_NAMA = "nama";
//    public static final String EXTRA_ALAMAT = "alamat";
//    public static final String EXTRA_NOTELP = "notelp";

    Button btnTambah;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;
    List<Anggota> mAnggotaList;
//    AnggotaAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvAnggota);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btnTambah = (Button) findViewById(R.id.btnTambahAnggota);

        getAnggota();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaActivity.this, AnggotaTambahActivity.class);
                startActivity(i);
            }
        });

    }

    private void getAnggota() {

        //Memunculkan Dialog
        progressDialog = ProgressDialog.show(this, "Data Anggota", "Memuat Data ...", true, false);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        //Memanggil interface dari model getAnggota, dan memberikan value ke anggota call
        Call<GetAnggota> anggotaCall = mApiInterface.getAnggota();
        //anggotaCall diurutkan nilainya dan akan ditampilkan nanti di dalam fungsi enqueue
        anggotaCall.enqueue(new Callback<GetAnggota>() {
            //Terdapat 2 respon, OnResponse jika response nya dapat diterima , On failure jika responnya ditolak
            @Override
            //Jika berhasil maka ...
            public void onResponse(Call<GetAnggota> call, Response<GetAnggota> response) {
                if (response.isSuccessful()){
                    //Progress dialog tadi yang sudah berjalan dihentikan terlebih dahulu
                    progressDialog.dismiss();
                    //value yang kita dapat tadi dari enqueue diambil datanya, dan dimasukkan di list anggotaList
                    List<Anggota> anggotaList = response.body().getListDataAnggotae();

//                    Log.d("Retrofit Get", "Jumlah data pembelian: " +
//                            String.valueOf(anggotaList.size()));

                    //Setelah data didapatkan, lalu dimasukkan ke dalam adapternya
                    mAdapter = new AnggotaAdapter(anggotaList, AnggotaActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
//                    mAdapter.setOnClickListener(AnggotaActivity.this);

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(AnggotaActivity.this, "Gagal mengambil data Anggota", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetAnggota> call, Throwable t) {
                // Log error
                progressDialog.dismiss();
                Toast.makeText(AnggotaActivity.this, "Tidak dapat menyambungkan, cek kembali koneksi anda", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    public void onItemClick(int position) {
//        Intent detailIntent = new Intent(this, AnggotaDetailActivity.class);
//        Anggota clickedItem = mAnggotaList.get(position);
//
//        detailIntent.putExtra(EXTRA_ID, clickedItem.getId_anggota());
//        detailIntent.putExtra(EXTRA_NAMA, clickedItem.getNama());
//        detailIntent.putExtra(EXTRA_ALAMAT, clickedItem.getAlamat());
//        detailIntent.putExtra(EXTRA_NOTELP, clickedItem.getNo_telp());
//
//        startActivity(detailIntent);
//    }
}
