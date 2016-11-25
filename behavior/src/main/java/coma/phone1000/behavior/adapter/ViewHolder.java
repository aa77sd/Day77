package coma.phone1000.behavior.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import coma.phone1000.behavior.R;

/**
 * Created by ZZY on 2016/11/25.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title;
    public ViewHolder(View itemView) {
        super(itemView);
        image= (ImageView) itemView.findViewById(R.id.teach_item_image);
        title= (TextView) itemView.findViewById(R.id.teach_item_title);
    }
}
