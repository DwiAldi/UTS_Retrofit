package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/28/2017.
 */

public class Buku {

    @SerializedName("id_buku")
    private String id_buku;
    @SerializedName("nama_buku")
    private String nama_buku;
    @SerializedName("penulis")
    private String penulis;
    @SerializedName("penerbit")
    private String penerbit;

    public Buku() {
    }

    public Buku(String id_buku, String nama_buku, String penulis, String penerbit) {
        this.id_buku = id_buku;
        this.nama_buku = nama_buku;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public void setNama_buku(String nama_buku) {
        this.nama_buku = nama_buku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
