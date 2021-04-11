package com.example.belajarfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (Button) findViewById(R.id.btnFirstFragment);
        secondFragment = (Button) findViewById(R.id.btnSecondFragment);

        firstFragment.setOnClickListener(v -> {
        loadFragment(new FirstFragment());
        });

        secondFragment.setOnClickListener(v -> {
            loadFragment(new SecondFragment());
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (fragment !=null){
            transaction.replace(R.id.showFrameLayout,fragment);
            transaction.commit();
        }
    }
}