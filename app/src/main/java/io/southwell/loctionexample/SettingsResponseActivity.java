package io.southwell.loctionexample;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsResponseActivity extends AppCompatActivity {
    Button btnSettings;
    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_response);

        btnSettings = (Button)findViewById(R.id.btnSettings);
        response = (TextView)findViewById(R.id.response);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.setText("sending request");
                int off = 0;
                try {
                    off = Settings.Secure.getInt(getContentResolver(), Settings.Secure.LOCATION_MODE);
                    if(off==0){
                        response.setText("location mode is off");
                    }
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
