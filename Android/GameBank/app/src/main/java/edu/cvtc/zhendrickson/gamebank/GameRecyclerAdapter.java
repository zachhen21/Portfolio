package edu.cvtc.zhendrickson.gamebank;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.ViewHolder> {

    //Member variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private Cursor mCursor;
    private int mGameTitlePosition;
    private int mGamePricePosition;
    private int mGameConsolePosition;
    private int mGameDatePosition;
    private int mGameConditionPosition;
    private int mGameOwnedPosition;
    private int mIdPosition;

    public GameRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(context);

        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if(mCursor != null) {
            mGameTitlePosition = mCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_TITLE);
            mGamePricePosition = mCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_PRICE);
            mGameConsolePosition = mCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONSOLE);
            mGameDatePosition = mCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_DATE);
            mGameConditionPosition = mCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONDITION);
            mIdPosition = mCursor.getColumnIndex(GameInfoEntry._ID);
        }
    }

    public void changeCursor(Cursor cursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = cursor;

        populateColumnPositions();

        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mCursor.moveToPosition(position);

        String gameTitle = mCursor.getString(mGameTitlePosition);
        String gamePrice = mCursor.getString(mGamePricePosition);
        String gameConsole = mCursor.getString(mGameConsolePosition);
        String gameDate = mCursor.getString(mGameDatePosition);
        String gameCondition = mCursor.getString(mGameConditionPosition);
        int id = mCursor.getInt(mIdPosition);

        holder.mGameTitle.setText(gameTitle);
        holder.mGamePrice.setText(gamePrice);
        holder.mGameConsole.setText(gameConsole);
        holder.mGameDate.setText(gameDate);
        holder.mGameCondition.setText(gameCondition);
        holder.mId = id;
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //member variables
        public final TextView mGameTitle;
        public final TextView mGamePrice;
        public final TextView mGameConsole;
        public final TextView mGameDate;
        public final TextView mGameCondition;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mGameTitle = (TextView)itemView.findViewById(R.id.game_title);
            mGamePrice = (TextView)itemView.findViewById(R.id.price_text);
            mGameConsole = (TextView)itemView.findViewById(R.id.console_text);
            mGameDate = (TextView)itemView.findViewById(R.id.date_text);
            mGameCondition = (TextView)itemView.findViewById(R.id.condition_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, GameActivity.class);
                    intent.putExtra(GameActivity.GAME_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
