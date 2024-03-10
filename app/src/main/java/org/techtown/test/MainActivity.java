package org.techtown.test;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    public void changeImage() {
        if (imageIndex == 0) {
            imageView.setVisibility(imageView.VISIBLE);
            imageView2.setVisibility(imageView.INVISIBLE);

            imageIndex = 1;
        }
        else if (imageIndex == 1) {
            imageView2.setVisibility(imageView.VISIBLE);
            imageView.setVisibility(imageView.INVISIBLE);

            imageIndex = 0;
        }
    }
}