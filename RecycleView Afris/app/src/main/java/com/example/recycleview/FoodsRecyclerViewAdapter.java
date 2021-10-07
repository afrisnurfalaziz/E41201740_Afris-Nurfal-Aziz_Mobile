package com.example.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Mengextends recylerview adapter
public class FoodsRecyclerViewAdapter extends RecyclerView.Adapter<FoodsRecyclerViewAdapter.FoodViewHolder> {

    //Membuat data dari ararylist
    ArrayList<Foods> arrayListFoods;

    //Membuat constructor
    public FoodsRecyclerViewAdapter(ArrayList<Foods> arrayListFoods) {
        this.arrayListFoods = arrayListFoods;
    }

    //Implement method dari FoodViewHolder
    @NonNull
    @Override
    public FoodsRecyclerViewAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Membuat objek View yang mengambil data dari layout item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsRecyclerViewAdapter.FoodViewHolder holder, int position) {
        //Membuat konstanta untuk meng get setiap objek dari array list
        final Foods foods = arrayListFoods.get(position);

        //Memanggil set text nilai yang tersimpan di dalam array list
        holder.textViewTitle.setText(foods.getTitle());
        holder.textViewRating.setText(String.valueOf(foods.getRating()));
        holder.textViewJambuka.setText(foods.getJamBuka());

        //Membuat action jika di klik akan pindah ke detail foods
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailFoodsActivity.class);
                intent.putExtra("FOODS", foods);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    //Mmebuat fungsi untuk memanggil jumlah data
    @Override
    public int getItemCount() {
        return arrayListFoods.size();
    }

    //Membuat class untuk FoodViewHolder
    public class FoodViewHolder extends RecyclerView.ViewHolder {
        //Mendeklrasikan widget atau view yang ada di dalam item
        TextView textViewTitle, textViewRating, textViewJambuka;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            //Memanggil findView dari id
            textViewTitle = itemView.findViewById(R.id.Title);
            textViewRating = itemView.findViewById(R.id.Rating);
            textViewJambuka = itemView.findViewById(R.id.JamBuka);
        }
    }
}
