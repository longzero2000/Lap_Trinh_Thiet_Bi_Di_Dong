package com.nguyenvanhailong.books_sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText title_input, desc_input, pages_input, price_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        desc_input = findViewById(R.id.desc_input);
        pages_input = findViewById(R.id.pages_input);
        price_input = findViewById(R.id.price_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        desc_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()),
                        Integer.valueOf(price_input.getText().toString().trim()));
            }
        });
    }
}