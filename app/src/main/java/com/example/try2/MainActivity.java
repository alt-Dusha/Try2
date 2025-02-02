package com.example.try2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView note = findViewById(R.id.Note);

        String[] notes = { "до", "ре", "ми", "фа", "соль", "ля", "си", "до#", "ре#", "фа#", "соль#",
                "ля#"};

        for (int i = 1; i <= 12; i++){
            int buttonID = getResources().getIdentifier("b" + i, "id", getPackageName());
            Button button = findViewById(buttonID);
            String name = notes[i-1];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    note.setText(name);
                }
            });
          }

    }
}