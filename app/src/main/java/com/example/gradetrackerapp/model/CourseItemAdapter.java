package com.example.gradetrackerapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gradetrackerapp.R;

import java.util.ArrayList;
public class CourseItemAdapter extends RecyclerView.Adapter<CourseItemAdapter.ViewHolder> {
    private ArrayList<CourseItem> list;
    private OnItemClickedListener listener;
    public interface OnItemClickedListener {
        void onEditClick(int position);
        void onDelete(int position);
    }
    public void setOnItemClickListener(OnItemClickedListener listener) {
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCourse;
        public TextView textViewProfessor;
        public ImageView imageView;
        public ImageView imageView2;

        public ViewHolder(@NonNull View itemView, final OnItemClickedListener listener) {
            super(itemView);
            textViewCourse = itemView.findViewById(R.id.textViewCourse);
            textViewProfessor = itemView.findViewById(R.id.textViewProfessor);
            imageView = itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.imageView2);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                        }
                    }
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDelete(position);
                        }
                    }
                }
            });
        }
    }
    public CourseItemAdapter(ArrayList<CourseItem> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_items, parent, false);
        ViewHolder vh = new ViewHolder(v, listener);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseItem currentItem = list.get(position);
        holder.textViewCourse.setText(currentItem.getCourseName());
        holder.textViewProfessor.setText(currentItem.getProfessorName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}