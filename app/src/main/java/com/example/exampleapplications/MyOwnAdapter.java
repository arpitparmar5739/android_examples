package com.example.exampleapplications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {
    String titles[], description[];
    Context ctx;
    int images[];

    public MyOwnAdapter(Context ctx, String titles[], String description[], int img[]) {
        this.ctx = ctx;

        this.titles = titles;
        this.description = description;
        this.images = img;
    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View myOwnView = myInflater.inflate(R.layout.my_row, parent, false);
        return new MyOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        holder.title.setText(this.titles[position]);
        holder.description.setText(this.description[position]);
        holder.imageView.setImageResource(this.images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView imageView;

        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
