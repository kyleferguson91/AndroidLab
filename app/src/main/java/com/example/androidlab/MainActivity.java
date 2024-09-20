package com.example.androidlab;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



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
        setContentView(R.layout.activity_main_linear);

        Button messagebutton = findViewById(R.id.button2);

        messagebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Code to execute when the button is clicked
                Toast.makeText(MainActivity.this, getString(R.string.toast_message) , Toast.LENGTH_SHORT).show();

                EditText suppliedtext = findViewById(R.id.editTextText);

                TextView textmessage = findViewById(R.id.textView);
                textmessage.setText(suppliedtext.getText());
            }
        });


        CheckBox listencheckbox = findViewById(R.id.checkBox);

        listencheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // CheckBox is checked
                Toast.makeText(MainActivity.this, "CheckBox Checked", Toast.LENGTH_SHORT).show();
            } else {
                // CheckBox is unchecked
                Toast.makeText(MainActivity.this, "CheckBox Unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}