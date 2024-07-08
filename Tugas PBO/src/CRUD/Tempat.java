package CRUD;

public class Tempat extends Peta {

    private String kodeTempat;
    private String namaTempat;
    private String kodeJenis;
    private String gambar;
    private String kodeAgama;
    private String longitude;
    private String latitude;

    public Tempat() {
    }

    public Tempat(String kodeTempat, String namaTempat, String kodeJenis, String gambar, String kodeAgama, String longitude, String latitude) {
        this.kodeTempat = kodeTempat;
        this.namaTempat = namaTempat;
        this.kodeJenis = kodeJenis;
        this.gambar = gambar;
        this.kodeAgama = kodeAgama;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setKodeTempat(String kodeTempat) {
        this.kodeTempat = kodeTempat;
    }

    public String getKodeTempat() {
        return kodeTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setKodeJenis(String kodeJenis) {
        this.kodeJenis = kodeJenis;
    }

    public String getKodeJenis() {
        return kodeJenis;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getGambar() {
        return gambar;
    }

    public void setKodeAgama(String kodeAgama) {
        this.kodeAgama = kodeAgama;
    }

    public String getKodeAgama() {
        return kodeAgama;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }
}