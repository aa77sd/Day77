package coma.phone1000.behavior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import coma.phone1000.behavior.adapter.TeachAdapter;
import coma.phone1000.behavior.model.Movie;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecucler;
    private TeachAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        setupView();
    }

    private void setupView() {
        List<Movie>data=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Movie movie=new Movie();
            movie.setTitle("呵呵"+i);
            data.add(movie);
        }
        adapter.updateRes(data);
    }

    private void initView() {
        mRecucler = (RecyclerView) findViewById(R.id.teach_recucler);
        adapter = new TeachAdapter(this);
        mRecucler.setAdapter(adapter);
    }

    public void scrollTop(View view) {
//        mRecucler.scrollTo(0,0);
        RecyclerView.LayoutManager layoutManager = mRecucler.getLayoutManager();
        layoutManager.scrollToPosition(0);
    }
}
