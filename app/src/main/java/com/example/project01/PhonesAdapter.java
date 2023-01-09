package com.example.project01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01.databinding.RecyclerHandlerBinding;

import java.util.ArrayList;

public class PhonesAdapter extends RecyclerView.Adapter<PhonesAdapter.PhonesHolder> {
    private ArrayList<Phones> phones;
    private onUserClickListener listener;
    private RecyclerHandlerBinding binding;

    public PhonesAdapter(ArrayList<Phones> phones, onUserClickListener listener) {
        this.phones = phones;
        this.listener = listener;
    }

    public ArrayList<Phones> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phones> phones) {
        this.phones = phones;
    }

    @NonNull
    @Override
    public PhonesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_handler,parent,false);
        return new PhonesHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhonesHolder holder, int position) {
        Phones phone = phones.get(position);
        holder.bind(phone);
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    class PhonesHolder extends RecyclerView.ViewHolder{
        Phones phone;

        public PhonesHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecyclerHandlerBinding.bind(itemView);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onUserClicked(phone);
                }
            });
        }
        void bind(Phones phone){
            this.phone = phone;
            binding.rvIvPhone.setImageResource(phone.getImage());
            binding.rvTvName.setText(phone.getName());
            binding.rvTvPrice.setText("$"+phone.getPrice());
        }
    }
    interface onUserClickListener{
        void onUserClicked(Phones phone);
    }
}
