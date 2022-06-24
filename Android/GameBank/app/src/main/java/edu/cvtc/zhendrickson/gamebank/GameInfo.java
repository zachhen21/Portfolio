package edu.cvtc.zhendrickson.gamebank;

import android.os.Parcel;
import android.os.Parcelable;

public class GameInfo implements Parcelable {
   //Member Attributes
    private String mTitle;
    private String mPrice;
    private String mConsole;
    private String mDate;
    private String mCondition;
    private String mOwned;
    private int mId;

    //Constructors
    public GameInfo(String title, String price, String console, String date, String condition, String owned) {
        mTitle = title;
        mPrice = price;
        mConsole = console;
        mDate = date;
        mCondition = condition;
        mOwned = owned;
    }

    public GameInfo(int id, String title, String price, String console, String date, String condition, String owned) {
        mId = id;
        mTitle = title;
        mPrice = price;
        mConsole= console;
        mDate = date;
        mCondition = condition;
        mOwned = owned;
    }

    //Getters and Setters
    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getConsole() {
        return mConsole;
    }

    public void setConsole(String console) {
        mConsole = console;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getCondition() {
        return mCondition;
    }

    public void setCondition(String condition) {
        mCondition = condition;
    }

    public String getOwned() {
        return mOwned;
    }

    public void setOwned(String owned) {
        mOwned = owned;
    }

    //compare key
    private String getCompareKey() {
        return mTitle + "|" + mPrice + "|" + mConsole + "|" + mDate + "|" + mCondition + "|" + mOwned;
    }

    //Checking for duplicate game entries
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo that = (GameInfo) o;
        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    protected GameInfo(Parcel parcel) {
        setTitle(parcel.readString());
        setPrice(parcel.readString());
        setConsole(parcel.readString());
        setDate(parcel.readString());
        setCondition(parcel.readString());
        setOwned(parcel.readString());
    }

    public static final Creator<GameInfo> CREATOR = new Creator<GameInfo>() {
        @Override
        public GameInfo createFromParcel(Parcel parcel) {
            return new GameInfo(parcel);
        }

        @Override
        public GameInfo[] newArray(int size) {
            return new GameInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mTitle);
        parcel.writeString(mPrice);
        parcel.writeString(mConsole);
        parcel.writeString(mDate);
        parcel.writeString(mCondition);
        parcel.writeString(mOwned);
    }
}
