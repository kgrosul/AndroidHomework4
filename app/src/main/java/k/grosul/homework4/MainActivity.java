package k.grosul.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View mainLayout = findViewById(R.id.main_layout);
        mainLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final Intent intent;
        switch (view.getId()) {
            case R.id.main_layout:
                intent = new Intent(this, LargeActivity.class);
                break;
            default:
                throw new IllegalArgumentException("Unknown button");
        }
        startActivity(intent);

    }
}