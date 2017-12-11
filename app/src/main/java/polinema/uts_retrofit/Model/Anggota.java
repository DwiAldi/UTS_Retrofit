package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/28/2017.
 */

public class Anggota {

    @SerializedName("id_anggota")
    private String id_anggota;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("no_telp")
    private String no_telp;

    public Anggota() {
    }

    public Anggota(String id_anggota, String nama, String alamat, String no_telp) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
