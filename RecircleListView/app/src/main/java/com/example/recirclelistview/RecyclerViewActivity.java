package com.example.recirclelistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvMahasiswa;
    private MahasiswaAdapter adapterMahasiswa;
    private ArrayList<Mahasiswa> mDataMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        addData();

        adapterMahasiswa = new MahasiswaAdapter(mDataMahasiswa);

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        rvMahasiswa.setAdapter(adapterMahasiswa);
    }

    private void addData(){
        mDataMahasiswa = new ArrayList<>();
        mDataMahasiswa.add(new Mahasiswa("Moh.Ardias Ade Aga", "E41192114", "12345678"));
        mDataMahasiswa.add(new Mahasiswa("Nona Shafa Efendy", "E41192115", "12345687"));
        mDataMahasiswa.add(new Mahasiswa("Denisha Safa R.R.", "E41192116", "12345689"));
        mDataMahasiswa.add(new Mahasiswa("Novita Purwitaning D.", "E41192117", "12345693"));
    }
}