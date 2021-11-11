package com.example.pet_out.Steps;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pet_out.R;
import java.util.Timer;
import java.util.TimerTask;

public class StepsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);



        TimerTask tarea =new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(StepsActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo= new Timer();
        tiempo.schedule(tarea, 5000);
    }
}