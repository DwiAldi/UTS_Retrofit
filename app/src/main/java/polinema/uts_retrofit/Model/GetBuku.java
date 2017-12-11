package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldid on 11/28/2017.
 */

public class GetBuku {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Buku> listDataBuku;
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
    public List<Buku> getListDataBukue() {
        return listDataBuku;
    }
    public void setListDataBukue(List<Buku> listDataBukue) {
        this.listDataBuku = listDataBukue;
    }
}
