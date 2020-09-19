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

public class AssignmentItemAdapter extends RecyclerView.Adapter<AssignmentItemAdapter.ViewHolder> {
    private ArrayList<AssignmentItem> list;
    private AssignmentItemAdapter.OnItemClickedListener listener;
    public interface OnItemClickedListener {
        void onEditClick(int position);
        void onDelete(int position);
    }
    public void setOnItemClickListener(AssignmentItemAdapter.OnItemClickedListener listener) {
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCourse2;
        public TextView textViewAssignment2;
        public TextView textViewGrade;
        public ImageView imageView;
        public ImageView imageView2;

        public ViewHolder(@NonNull View itemView, final AssignmentItemAdapter.OnItemClickedListener listener) {
            super(itemView);
            textViewCourse2 = itemView.findViewById(R.id.textViewCourse2);
            textViewAssignment2 = itemView.findViewById(R.id.textViewAssignment2);
            textViewGrade = itemView.findViewById(R.id.textViewGrade);
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
    public AssignmentItemAdapter(ArrayList<AssignmentItem> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_items, parent, false);
        ViewHolder vh = new ViewHolder(v, listener);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AssignmentItem assignmentItem = list.get(position);
        holder.textViewCourse2.setText(assignmentItem.getCourseName());
        holder.textViewAssignment2.setText(assignmentItem.getAssignmentName());
        holder.textViewGrade.setText(assignmentItem.getGrade() + "");
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}

