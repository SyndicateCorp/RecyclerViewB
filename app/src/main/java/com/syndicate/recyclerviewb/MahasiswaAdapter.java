package com.syndicate.recyclerviewb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {

    private List<MahasiswaModel> _mahasiswaModelList;

    public MahasiswaAdapter(List<MahasiswaModel> _mahasiswaModelList) {
        this._mahasiswaModelList = _mahasiswaModelList;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_mahasiswa, parent, false);
        return new MahasiswaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {

        int no = position + 1;
        holder._noTextView.setText(no + ".");

        MahasiswaModel mm = _mahasiswaModelList.get(position);

        holder._jkImageView.setImageResource(R.drawable.boy);
        if (mm.getJenisKelamin().toLowerCase().equals("perempuan")){
            holder._jkImageView.setImageResource(R.drawable.girl);
        }
        String jp = mm.getJP();
        jp = jp.substring(0, 2); //hanya mangambil 2 karakter depan
        holder._jpTextView.setText(jp);
    }

    @Override
    public int getItemCount() {
        int count = (_mahasiswaModelList != null)? _mahasiswaModelList.size() : 0;
        return count;
    }
}
