package com.example.recycleview_parttwo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recycleview_parttwo.continent.Continent_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            Continent_Fragment continentFragment = new Continent_Fragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Continent_Fragment()).commit();
        }
    
}