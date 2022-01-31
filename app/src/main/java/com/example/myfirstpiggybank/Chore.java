package com.example.myfirstpiggybank;

import android.os.Parcel;
import android.os.Parcelable;

public class Chore implements Parcelable {
    private String name;
    private String desc;
    private int value;

    public static final Parcelable.Creator<Chore> CREATOR = new Parcelable.Creator<Chore>() {

        @Override
        public Chore createFromParcel(Parcel parcel) {
            return new Chore(parcel);
        }

        @Override
        public Chore[] newArray(int size) {
            return new Chore[0];
        }
    };

    public Chore(Parcel parcel){
        name = parcel.readString();
        desc = parcel.readString();
        value = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(value);
    }

    public Chore(String name, String desc, int value){
        this.name = name;
        this.desc = desc;
        this.value = value;
    }


    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public int getValue(){
        return value;
    }
}
