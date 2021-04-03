package k.grosul.homework4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleVeiwAdapter extends RecyclerView.Adapter<RecycleVeiwAdapter.ViewHolder> {
    private final Context context;
    private final LayoutInflater inflater;
    private final OnItemClickListener onItemClickListener;

    public RecycleVeiwAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = (OnItemClickListener) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                inflater.inflate(R.layout.list_item, parent, false),
                onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(R.string.text);
        holder.imageView.setImageResource(R.drawable.picture);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 10;
    } // заглушка. В жизни тут будет количество объектов, полученных по сети


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView imageView;
        private final TextView textView;
        private final OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picture);
            imageView.setOnClickListener(this);
            this.onItemClickListener = onItemClickListener;
            textView = itemView.findViewById(R.id.text);
        }


        @Override
        public void onClick(View v) {
            onItemClickListener.OnClick(getAdapterPosition());

        }
    }

    public interface OnItemClickListener {
        void OnClick(int position);
    }
}

