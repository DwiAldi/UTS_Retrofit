package polinema.uts_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import polinema.uts_retrofit.Model.PostPutDelBuku;
import polinema.uts_retrofit.Rest.ApiClient;
import polinema.uts_retrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuUpdateActivity extends AppCompatActivity {

    TextView edtId, edtNama, edtPenulis, edtPenerbit;
    CardView btnSubmit;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_update);

        edtId = (TextView) findViewById(R.id.txtUpdateIdBuku);
        edtNama = (TextView) findViewById(R.id.txtUpdateNamaBuku);
        edtPenulis = (TextView) findViewById(R.id.txtUpdatePenulisBuku);
        edtPenerbit = (TextView) findViewById(R.id.txtUpdatePenerbitBuku);

        btnSubmit = (CardView) findViewById(R.id.cvUpdateBuku);

        Intent i = getIntent();
        edtId.setText(i.getStringExtra("id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(i.getStringExtra("nama"));
        edtPenulis.setText(i.getStringExtra("penulis"));
        edtPenerbit.setText(i.getStringExtra("penerbit"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelBuku> updateBukuCall = mApiInterface.putBuku(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtPenulis.getText().toString(),
                        edtPenerbit.getText().toString());

                updateBukuCall.enqueue(new Callback<PostPutDelBuku>() {
                    @Override
                    public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
                        Intent i = new Intent(BukuUpdateActivity.this, BukuActivity.class);
                        startActivity(i);
                        Toast.makeText(BukuUpdateActivity.this,"Data berhasil diupdate",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



    }
}
