package com.example.belajarfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private Button btnShowMessage;

    // Dijalankan saat pembuatan View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_first_fragment, container, false);
    }

    // Dijalankan ketika view sudah dibuat
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnShowMessage = view.findViewById(R.id.firstButton);
        btnShowMessage.setOnClickListener(
                v -> Toast.makeText(getContext().getApplicationContext(), "Ini fragment Pertama" , Toast.LENGTH_SHORT).show());
    }
}