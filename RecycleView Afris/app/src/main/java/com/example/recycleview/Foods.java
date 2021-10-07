package com.example.recycleview;

import android.os.Parcel;
import android.os.Parcelable;

//Inisialisasi data-data
public class Foods implements Parcelable {
    private String title;
    private double rating;
    private String jamBuka;
    private String alamat;
    private String deskripsi;

    //Membuat constructor
    public Foods(String title, double rating, String jamBuka, String alamat, String deskripsi) {
        this.title = title;
        this.rating = rating;
        this.jamBuka = jamBuka;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
    }

    //Membuat Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    //Membuat Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeDouble(this.rating);
        dest.writeString(this.jamBuka);
        dest.writeString(this.alamat);
        dest.writeString(this.deskripsi);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.rating = source.readDouble();
        this.jamBuka = source.readString();
        this.alamat = source.readString();
        this.deskripsi = source.readString();
    }

    protected Foods(Parcel in) {
        this.title = in.readString();
        this.rating = in.readDouble();
        this.jamBuka = in.readString();
        this.alamat = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<Foods> CREATOR = new Creator<Foods>() {
        @Override
        public Foods createFromParcel(Parcel source) {
            return new Foods(source);
        }

        @Override
        public Foods[] newArray(int size) {
            return new Foods[size];
        }
    };
}
