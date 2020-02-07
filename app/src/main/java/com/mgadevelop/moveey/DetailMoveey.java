package com.mgadevelop.moveey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMoveey extends AppCompatActivity {

    private TextView title, sinopsisD;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_moveey);

        title=findViewById(R.id.titleDetail);
        sinopsisD=findViewById(R.id.sinopsisDetail);
        poster=findViewById(R.id.posterDetail);

        MoveeyModel moveeyModel = getIntent().getParcelableExtra(MainActivity.SELECTED_MOV);
        title.setText(moveeyModel.getJudul());
        sinopsisD.setText(moveeyModel.getSinopsis());
        poster.setImageResource(moveeyModel.getPoster());
        setTitle(moveeyModel.getJudul());
    }
}
