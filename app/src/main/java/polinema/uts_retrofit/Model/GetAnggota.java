package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldid on 11/28/2017.
 */

public class GetAnggota {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Anggota> listDataAnggota;
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
    public List<Anggota> getListDataAnggotae() {
        return listDataAnggota;
    }
    public void setListDataAnggotae(List<Anggota> listDataAnggotae) {
        this.listDataAnggota = listDataAnggotae;
    }
}
