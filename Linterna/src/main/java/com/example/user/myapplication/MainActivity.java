package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    Button encenderButton;
    Boolean apagado = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    encenderButton = (Button) findViewById(R.id.buttonEncender);
        camera = Camera.open();

        encenderButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Parameters parameters = camera.getParameters();
                if (apagado) {
                    parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    apagado=false;
                } else {
                    parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                    apagado=true;
                }
                camera.setParameters(parameters);
            }
        });

    }
}
