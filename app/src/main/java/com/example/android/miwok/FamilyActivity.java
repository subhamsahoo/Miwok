package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mcompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


       final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("father", "әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new word("son", "angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new word("younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new word("grandmother ", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        wordAdapter itemsadapter = new wordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(itemsadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                word currentWord = words.get(i);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(FamilyActivity.this,currentWord.getAudioResourceId());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mcompletionListener);

            }
        });
    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
