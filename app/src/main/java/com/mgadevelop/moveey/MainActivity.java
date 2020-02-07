package com.mgadevelop.moveey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListMoveeyAdapter movAdapter;

    private ArrayList<MoveeyModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOV = "Selected Movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        setAdapter();
    }

    private void setAdapter() {
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulAbominable), getString(R.string.sinopsisAbominable), R.drawable.abominable));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulBlackAndBlue), getString(R.string.sinopsisBlackAndBlue), R.drawable.blacknblue));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulCountdown), getString(R.string.sinopsisCountdown), R.drawable.countdown));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulGeminiman), getString(R.string.sinopsisGeminiman), R.drawable.geminiman));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulJoker), getString(R.string.sinopsisJoker), R.drawable.joker));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulMaleficent), getString(R.string.sinopsisMaleficent), R.drawable.maleficent));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulTheAddamsFamily), getString(R.string.sinopsisTheAddamsFamily), R.drawable.theaddamsfamily));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulTheCurrentWar), getString(R.string.sinopsisTheCurrentWar), R.drawable.thecurrentwar));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulTheLighthouse), getString(R.string.sinopsisTheLighthouse), R.drawable.thelighthouse));
        modelList.add(new MoveeyModel(getResources().getString(R.string.judulZombieland), getString(R.string.sinopsisZombieland), R.drawable.zombieland));

        movAdapter = new ListMoveeyAdapter(MainActivity.this, modelList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movAdapter);

        movAdapter.SetOnItemClickListener(new ListMoveeyAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position, MoveeyModel model) {
                Intent goToDetailMovie = new Intent(MainActivity.this, DetailMoveey.class);
                goToDetailMovie.putExtra(MainActivity.SELECTED_MOV, model);
                startActivity(goToDetailMovie);

            }
        });
    }
}
