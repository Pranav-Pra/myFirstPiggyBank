package com.example.myfirstpiggybank;

import android.os.Parcel;
import android.os.Parcelable;

public class Chore implements Parcelable {
    private String name, desc, docID;
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
        docID = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(value);
        dest.writeString(docID);
    }

    public Chore(String name, String desc, int value, String docID){
        this.name = name;
        this.desc = desc;
        this.value = value;
        this.docID = docID;
    }

    public Chore(String name, String desc, int value){
        this.name = name;
        this.desc = desc;
        this.value = value;
        this.docID = "";
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public String getDocID(){
        return docID;
    }

    public int getValue(){
        return value;
    }
}
