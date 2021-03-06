package com.gtwatt.solarcreed;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gtwatt on 11/5/17.
 */

public class NewRecordFragment  extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_record, container,false);
        final EditText goodEgg,badEgg,usedFeed,newFeed,mortality,sickBird;
        goodEgg = (EditText)view.findViewById(R.id.input_new_good_egg);
        badEgg = (EditText)view.findViewById(R.id.damaged_egg_value);
        usedFeed = (EditText)view.findViewById(R.id.used_feed_value);

        newFeed = (EditText)view.findViewById(R.id.new_feed_value);
        mortality = (EditText)view.findViewById(R.id.mortality_value);
        sickBird = (EditText)view.findViewById(R.id.sick_bird_value);

        Button saveButton = (Button)view.findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Report report = new Report(1,Integer.parseInt(goodEgg.getText().toString()),Integer.parseInt(badEgg.getText().toString()),Integer.parseInt(mortality.getText().toString()),Integer.parseInt(sickBird.getText().toString()),Integer.parseInt(usedFeed.getText().toString()),Integer.parseInt(newFeed.getText().toString()));
                new DataBaseHandler(getContext()).addReport(report);
                Toast.makeText(getContext(),"Record Saved", Toast.LENGTH_SHORT);
            }
        });


        return view;
    }
}
