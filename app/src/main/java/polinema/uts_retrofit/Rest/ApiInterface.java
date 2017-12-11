package polinema.uts_retrofit.Rest;

import polinema.uts_retrofit.Model.GetAnggota;
import polinema.uts_retrofit.Model.GetBuku;
import polinema.uts_retrofit.Model.GetPeminjaman;
import polinema.uts_retrofit.Model.PostPutDelAnggota;
import polinema.uts_retrofit.Model.PostPutDelBuku;
import polinema.uts_retrofit.Model.PostPutDelPeminjaman;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by aldid on 11/22/2017.
 */

public interface ApiInterface {

    //Peminjaman
    @GET("peminjaman/user")
    Call<GetPeminjaman> getPeminjaman();
    @FormUrlEncoded
    @POST("peminjaman/user")
    Call<PostPutDelPeminjaman> postPeminjaman(@Field("id_peminjaman") String idPeminjaman,
                                            @Field("id_anggota") String idAnggota,
                                            @Field("id_buku") String idBuku,
                                            @Field("tgl_pinjam") String tgl_pinjam,
                                            @Field("tgl_kembali") String tgl_kembali);
    @FormUrlEncoded
    @PUT("peminjaman/user")
    Call<PostPutDelPeminjaman> putPeminjaman(@Field("id_peminjaman") String idPeminjaman,
                                           @Field("id_anggota") String idAnggota,
                                           @Field("id_buku") String idBuku,
                                           @Field("tgl_pinjam") String tgl_pinjam,
                                           @Field("tgl_kembali") String tgl_kembali);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "peminjaman/user", hasBody = true)
    Call<PostPutDelPeminjaman> deletePeminjaman(@Field("id_peminjaman") String idPeminjaman);

    //Anggota
    @GET("anggota/user")
    Call<GetAnggota> getAnggota();
    @FormUrlEncoded
    @POST("anggota/user")
    Call<PostPutDelAnggota> postAnggota(   @Field("id_anggota") String idAnggota,
                                           @Field("nama") String nama,
                                           @Field("alamat") String alamat,
                                           @Field("no_telp") String no_telp);
    @FormUrlEncoded
    @PUT("anggota/user")
    Call<PostPutDelAnggota> putanggota  (     @Field("id_anggota") String idAnggota,
                                              @Field("nama") String nama,
                                              @Field("alamat") String alamat,
                                              @Field("no_telp") String no_telp);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "anggota/user", hasBody = true)
    Call<PostPutDelAnggota> deleteAnggota(@Field("id_anggota") String idAnggota);

    //Buku
    @GET("buku/user")
    Call<GetBuku> getBuku();
    @FormUrlEncoded
    @POST("buku/user")
    Call<PostPutDelBuku> postBuku   (@Field("id_buku") String idBuku,
                                     @Field("nama_buku") String nama_buku,
                                     @Field("penulis") String penulis,
                                     @Field("penerbit") String penerbit);
    @FormUrlEncoded
    @PUT("buku/user")
    Call<PostPutDelBuku> putBuku    (@Field("id_buku") String idBuku,
                                     @Field("nama_buku") String nama_buku,
                                     @Field("penulis") String penulis,
                                     @Field("penerbit") String penerbit);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "buku/user", hasBody = true)
    Call<PostPutDelBuku> deleteBuku(@Field("id_buku") String idBuku);
}
