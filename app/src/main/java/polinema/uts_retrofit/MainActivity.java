package polinema.uts_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;
import polinema.uts_retrofit.Model.GetPeminjaman;
import polinema.uts_retrofit.Model.Peminjaman;
import polinema.uts_retrofit.Model.PostPutDelPeminjaman;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btGet, btUpdate, btInsert, btDelete;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGet = (Button) findViewById(R.id.btGet);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btInsert = (Button) findViewById(R.id.btInsert);
        btDelete = (Button) findViewById(R.id.btDelete);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetPeminjaman> peminjamanCall = mApiInterface.getPeminjaman();
                peminjamanCall.enqueue(new Callback<GetPeminjaman>() {
                    @Override
                    public void onResponse(Call<GetPeminjaman> call, Response<GetPeminjaman>
                            response) {
                        List<Peminjaman> pembelianList = response.body().getListDataPeminjamen();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " +
                                String.valueOf(pembelianList.size()));
                        mAdapter = new MyAdapter(pembelianList);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                    @Override
                    public void onFailure(Call<GetPeminjaman> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelPeminjaman> updatePeminjamanCall =
                        mApiInterface.putPeminjaman("peminjaman4","anggota1","buku1","2014-2-23","2014-2-24");
                updatePeminjamanCall.enqueue(new Callback<PostPutDelPeminjaman>() {
                    @Override
                    public void onResponse(Call<PostPutDelPeminjaman> call,
                                           Response<PostPutDelPeminjaman> response) {
                        Log.d("Retrofit Update", "Status Update: " +
                                String.valueOf(response.body().getStatus()));
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPeminjaman> call, Throwable t) {
                        Log.d("Retrofit Update", t.getMessage());
                    }
                });
            }
        });
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelPeminjaman> postPeminjamanCall =
                        mApiInterface.postPeminjaman("peminjaman4","anggota1","buku1","2014-1-23","2014-1-24");
                postPeminjamanCall.enqueue(new Callback<PostPutDelPeminjaman>() {
                    @Override
                    public void onResponse(Call<PostPutDelPeminjaman> call,
                                           Response<PostPutDelPeminjaman> response) {
                        Log.d("Retrofit Insert", "Status Insert: " +
                                String.valueOf(response.body().getStatus()));
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPeminjaman> call, Throwable t) {
                        Log.d("Retrofit Insert", t.getMessage());
                    }
                });
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelPeminjaman> deletePeminjaman =
                        mApiInterface.deletePeminjaman("peminjaman1");
                deletePeminjaman.enqueue(new Callback<PostPutDelPeminjaman>() {
                    @Override
                    public void onResponse(Call<PostPutDelPeminjaman> call,
                                           Response<PostPutDelPeminjaman> response) {
                        Log.i("Retrofit Delete", "Status Delete: " +
                                String.valueOf(response.body().getStatus()));
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPeminjaman> call, Throwable t) {
                        Log.i("Retrofit Delete", t.getMessage());
                    }
                });
            }
        });
    }
}
