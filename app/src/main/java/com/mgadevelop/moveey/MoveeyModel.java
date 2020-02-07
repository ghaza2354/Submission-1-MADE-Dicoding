package com.mgadevelop.moveey;

import android.os.Parcel;
import android.os.Parcelable;

public class MoveeyModel implements Parcelable {

    private String judul;
    private String sinopsis;
    private Integer poster;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public MoveeyModel(String judul, String sinopsis, Integer poster) {
        this.judul = judul;
        this.sinopsis = sinopsis;
        this.poster = poster;
    }

    public MoveeyModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.sinopsis);
        dest.writeValue(this.poster);
    }

    protected MoveeyModel(Parcel in) {
        this.judul = in.readString();
        this.sinopsis = in.readString();
        this.poster = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<MoveeyModel> CREATOR = new Creator<MoveeyModel>() {
        @Override
        public MoveeyModel createFromParcel(Parcel source) {
            return new MoveeyModel(source);
        }

        @Override
        public MoveeyModel[] newArray(int size) {
            return new MoveeyModel[size];
        }
    };
}
