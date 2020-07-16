package ua.vitamin.friendsjava.people;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ua.vitamin.friendsjava.R;

public class MainActivity extends AppCompatActivity {

    private MainActivityModel model;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.peopleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model = new MainActivityModel(recyclerView, getApplicationContext());
        model.onStart();
    }
}
