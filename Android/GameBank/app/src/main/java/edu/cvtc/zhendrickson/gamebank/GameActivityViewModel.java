package edu.cvtc.zhendrickson.gamebank;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class GameActivityViewModel extends ViewModel {
    //member constants/variables
    public static final String ORIGINAL_GAME_TITLE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_TITLE";
    public static final String ORIGINAL_GAME_PRICE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_PRICE";
    public static final String ORIGINAL_GAME_CONSOLE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_CONSOLE";
    public static final String ORIGINAL_GAME_DATE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_DATE";
    public static final String ORIGINAL_GAME_CONDITION  = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_CONDITION";
    public static final String ORIGINAL_GAME_OWNED = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_OWNED";

    public String mOriginalGameTitle;
    public String mOriginalGamePrice;
    public String mOriginalGameConsole;
    public String mOriginalGameDate;
    public String mOriginalGameCondition;
    public String mOriginalGameOwned;
    public boolean mIsNewlyCreated = true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_GAME_TITLE, mOriginalGameTitle);
        outState.putString(ORIGINAL_GAME_PRICE, mOriginalGamePrice);
        outState.putString(ORIGINAL_GAME_CONSOLE, mOriginalGameConsole);
        outState.putString(ORIGINAL_GAME_DATE, mOriginalGameDate);
        outState.putString(ORIGINAL_GAME_CONDITION, mOriginalGameCondition);
        outState.putString(ORIGINAL_GAME_OWNED, mOriginalGameOwned);
    }

    public void restoreState(Bundle inState) {
        mOriginalGameTitle = inState.getString(ORIGINAL_GAME_TITLE);
        mOriginalGamePrice = inState.getString(ORIGINAL_GAME_PRICE);
        mOriginalGameConsole = inState.getString(ORIGINAL_GAME_CONSOLE);
        mOriginalGameDate = inState.getString(ORIGINAL_GAME_DATE);
        mOriginalGameCondition = inState.getString(ORIGINAL_GAME_CONDITION);
        mOriginalGameOwned = inState.getString(ORIGINAL_GAME_OWNED);
    }
}
