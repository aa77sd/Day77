package coma.phone1000.behavior.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import coma.phone1000.behavior.R;
import coma.phone1000.behavior.model.Movie;

/**
 * Created by ZZY on 2016/11/25.
 */
public class TeachAdapter extends RecyclerView.Adapter<ViewHolder> {
   private LayoutInflater inflater;
    private List<Movie>data;
    public TeachAdapter(Context context){
        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();

    }
    public void updateRes(List<Movie>data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
