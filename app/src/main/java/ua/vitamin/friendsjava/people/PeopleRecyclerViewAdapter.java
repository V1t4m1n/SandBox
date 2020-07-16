package ua.vitamin.friendsjava.people;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ua.vitamin.friendsjava.R;
import ua.vitamin.friendsjava.dto.Result;
import ua.vitamin.friendsjava.dto.UserDTO;

public class PeopleRecyclerViewAdapter extends RecyclerView.Adapter<PeopleRecyclerViewAdapter.PeopleViewHolder> {

    private List<Result> resultList;
    private Context context;

    public PeopleRecyclerViewAdapter(List<Result> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    @NonNull
    @Override
    public PeopleRecyclerViewAdapter.PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_people, parent, false);
        return new PeopleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.title.setText(resultList.get(position).getName().getTitle());
        holder.fist.setText(resultList.get(position).getName().getFirst());
        holder.last.setText(resultList.get(position).getName().getLast());
        /*holder.age.setText(resultList.get(position).getDob().getAge());
        holder.gender.setText(resultList.get(position).getGender());*/

        Picasso.get().load(resultList.get(position).getPicture().getLarge()).into(holder.avatar);
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView fist;
        public TextView last;
        public TextView age;
        public TextView gender;
        public ImageView avatar;

        public PeopleViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTextView);
            fist = itemView.findViewById(R.id.fistTextView);
            last = itemView.findViewById(R.id.lastTextView);
            /*age = itemView.findViewById(R.id.ageTextView);
            gender = itemView.findViewById(R.id.genderTextView);*/
            avatar = itemView.findViewById(R.id.avatarImageView);
        }
    }
}
