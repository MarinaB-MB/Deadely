package com.deadely.retrofitex;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid_view);
        Call<List<Result>> call = new APIclient().apIinterface().getResults();
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful()) {

                } else {
                    Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_LONG).show();
                    adapter = new Adapter(response.body(), MainActivity.this);
                    gridView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
