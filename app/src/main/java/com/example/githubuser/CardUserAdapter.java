
package com.example.githubuser;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Collection;

class CardUserAdapter extends RecyclerView.Adapter<CardUserAdapter.CardViewHolder> implements Filterable {

    private AlphaAnimation animation = new AlphaAnimation(1F, 0.8F);
    private ArrayList<User> searchlist;
    private ArrayList<User> listUser;
    public CardUserAdapter(ArrayList<User> list){
        this.listUser = list;
        this.searchlist = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardUserAdapter.CardViewHolder holder, int i) {
        User user = listUser.get(i);
        Glide.with(holder.itemView.getContext())
                .load(user.getPhotoUser())
                .apply(new RequestOptions().override(130,130))
                .into(holder.imgUser);
        holder.tvNamaUser.setText(user.getNamaUser());
        holder.tvUserName.setText(user.getUsername());
        holder.tvLocation.setText(user.getLocationUser());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent moveDetailUser =new Intent(holder.itemView.getContext(), LayoutDetail.class);
                moveDetailUser.putExtra(LayoutDetail.EXTRA_USER, (Parcelable) listUser.get(i));
                holder.itemView.setAnimation(animation);
                holder.itemView.getContext().startActivity(moveDetailUser);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
        ArrayList<User> filterData =new ArrayList<>();

        if (constraint.toString().isEmpty()){
            filterData.addAll(searchlist);
        }else {
            for (User item : searchlist){
                if (item.getNamaUser().toLowerCase().contains(constraint.toString().toLowerCase())){
                    filterData.add(item);
                }
            }
        }
        FilterResults results =new FilterResults();
        results.values = filterData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listUser.clear();
            listUser.addAll((Collection<? extends User>) results.values);
            notifyDataSetChanged();
        }
    };

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUser;
        TextView tvNamaUser, tvUserName, tvLocation;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.photo_user);
            tvNamaUser = itemView.findViewById(R.id.nama_user);
            tvUserName = itemView.findViewById(R.id.user_name);
            tvLocation = itemView.findViewById(R.id.location);
        }
    }
}
