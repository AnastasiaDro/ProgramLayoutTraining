package com.geekbrains.programlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyFragment extends androidx.fragment.app.Fragment {

    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow tableRow2;
    TableRow tableRow3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout, container, false);
        tableLayout = view.findViewById(R.id.myLayout);
        tableLayout.setOrientation(TableLayout.VERTICAL);
        changeTableLayout();
        return view;
    }

    public void changeTableLayout(){
        tableRow1 = new TableRow(this.getContext());
        tableRow2 = new TableRow(this.getContext());
        tableRow3 = new TableRow(this.getContext());
        //создать текствью
        TextView textView1 = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        TextView textView3 = new TextView(getContext());
        //задать текст
        textView1.setText("TableRow1");
        textView2.setText("TableRow2");
        textView3.setText("TableRow3");
        //добавить в строки текст
        tableRow1.addView(textView1);
        tableRow2.addView(textView2);
        tableRow3.addView(textView3);
        //добавить строки в таблицу
        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);
    }


    public void post(AppCompatActivity activity,int placeId){

        FragmentManager fm = activity.getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(placeId, this);
        ft.commit();
    }


}
