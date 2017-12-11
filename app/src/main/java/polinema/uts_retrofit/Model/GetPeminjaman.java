package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldid on 11/22/2017.
 */

public class GetPeminjaman {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Peminjaman> listDataPeminjaman;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Peminjaman> getListDataPeminjamen() {
        return listDataPeminjaman;
    }
    public void setListDataPembelien(List<Peminjaman> listDataPeminjamen) {
        this.listDataPeminjaman = listDataPeminjamen;
    }
}
