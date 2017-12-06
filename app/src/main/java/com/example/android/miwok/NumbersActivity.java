package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_numbers);


       /* ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");*/

       /* LinearLayout root = (LinearLayout)findViewById(R.id.rootview);

        for(int index=0;index<words.size();index++)
        {
            TextView word = new TextView(this);
            word.setText(words.get(index));
            root.addView(word);
        }*/

        /*ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);*/


        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new word("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new word("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new word("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new word("five", "massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new word("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));


        wordAdapter itemsadapter = new wordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(itemsadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                word currentWord = words.get(i);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(NumbersActivity.this,currentWord.getAudioResourceId());

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
