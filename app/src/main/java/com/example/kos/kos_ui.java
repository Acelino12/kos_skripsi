package com.example.kos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class kos_ui implements Parcelable {

    private String name;
    private String detail;
    private int photo;

    public kos_ui(){

    }


    protected kos_ui(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<kos_ui> CREATOR = new Creator<kos_ui>() {
        @Override
        public kos_ui createFromParcel(Parcel in) {
            return new kos_ui(in);
        }

        @Override
        public kos_ui[] newArray(int size) {
            return new kos_ui[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
}
