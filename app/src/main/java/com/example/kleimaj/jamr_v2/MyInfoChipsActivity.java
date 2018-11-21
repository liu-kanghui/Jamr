package com.example.kleimaj.jamr_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.adroitandroid.chipcloud.ChipCloud;
import com.adroitandroid.chipcloud.ChipListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MyInfoChipsActivity extends AppCompatActivity {

    public static final int ARTIST_IDENTITY = 0;
    public static final int ARTIST_GENRE = 1;
    public static final int BAND_GENRE = 2;

    ChipCloud chips;
    String[] chipValues;
    String[] identities;
    String[] genres;
    ArrayList<String> currentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_chips);
        // context

        chips = findViewById(R.id.chip_cloud);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = findViewById(R.id.chipsTitle);
        initializeChips();

        switch (MyInfoActivity.chipsContext) {
            case ARTIST_IDENTITY: {
                title.setText("Music Identities");
                currentValues = MyInfoActivity.chosenIdentities;
                for (String s: identities) {
                    if (currentValues.contains(s)) {
                        chips.setSelectedChip(Arrays.asList(identities).indexOf(s));
                    }
                }
                break;
            }
            case ARTIST_GENRE: {
                title.setText("Music Genres");
                currentValues = MyInfoActivity.chosenGenres;
                for (String s: genres) {
                    if (currentValues.contains(s)) {
                        chips.setSelectedChip(Arrays.asList(genres).indexOf(s));
                    }
                }
                break;
            }
            case BAND_GENRE: {
                title.setText("Music Genres");
                currentValues = MyInfoActivity.chosenGenres;
                for (String s: genres) {
                    if (currentValues.contains(s)) {
                        chips.setSelectedChip(Arrays.asList(genres).indexOf(s));
                    }
                }
                break;
            }
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {

            switch (MyInfoActivity.chipsContext) {
                case ARTIST_IDENTITY: {
                    MyInfoActivity.updateIdentities();
                    break;
                }
                case ARTIST_GENRE: {
                    MyInfoActivity.updateGenres();
                    break;
                }
                case BAND_GENRE: {
                    MyInfoActivity.updateGenres();
                    break;
                }
            }
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeChips() {
        identities = getResources().getStringArray(R.array.identities);
        Arrays.sort(identities);
        genres = getResources().getStringArray(R.array.genres);
        Arrays.sort(genres);

        if (MyInfoActivity.chipsContext == ARTIST_IDENTITY) {
            chipValues = identities;
        } else {
            chipValues = genres;
        }

        new ChipCloud.Configure().chipCloud(chips).labels(chipValues).chipListener(new ChipListener() {
            @Override
            public void chipSelected(int index) {
                if (!currentValues.contains(chipValues[index])) {
                    currentValues.add(chipValues[index]);
                }
            }
            @Override
            public void chipDeselected(int index) {
                currentValues.remove(chipValues[index]);
            }
        }).build();
    }

}
