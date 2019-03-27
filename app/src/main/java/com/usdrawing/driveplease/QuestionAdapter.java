package com.usdrawing.driveplease;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

    private List<Item> QuestionsList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, link, guid, description, author, category, pubDate;
        Button answerA, answerB, answerC, answerD;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            link = (TextView) view.findViewById(R.id.link);
            guid = (TextView) view.findViewById(R.id.guid);
            description = (TextView) view.findViewById(R.id.description);
            author = (TextView) view.findViewById(R.id.author);
            category = (TextView) view.findViewById(R.id.category);
            pubDate = (TextView) view.findViewById(R.id.pubDate);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "clicked=" + getAdapterPosition() + " " +
                    v.getResources().getResourceName(v.getId()), Toast.LENGTH_SHORT).show();

        }
    }

    public QuestionAdapter(Context context, List<Item> itemList) {
        super();
        this.QuestionsList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = QuestionsList.get(position);

        holder.title.setText(item.getTitle());
        holder.link.setText(item.getLink());
        holder.guid.setText(item.getGuid());
        holder.description.setText(item.getDescription());
        holder.author.setText(item.getAuthor());
        holder.category.setText(item.getCategory());
        holder.pubDate.setText(item.getPubDate());

        final int pos0 = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            final int pos = pos0;

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item selected " + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return QuestionsList.size();
    }
}
