package com.example.demo20;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class wordlistadapter extends RecyclerView.Adapter<wordlistadapter.ViewHolder> {


    private int row_layoutObj;
    private ArrayList<Item> wordList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(row_layoutObj, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView item = holder.item;
        item.setText(wordList.get(position).getName());
    }

    // Constructor of the class
    public wordlistadapter(int layoutId, ArrayList<Item> itemList) {
        row_layoutObj = layoutId;
        this.wordList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return wordList == null ? 0 : wordList.size();
    }



    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView item;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.row_textView);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }
    }
}
