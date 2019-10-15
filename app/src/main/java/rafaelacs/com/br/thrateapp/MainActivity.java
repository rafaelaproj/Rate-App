package rafaelacs.com.br.thrateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rafaelacs.com.br.thrateapp.util.RateDialogManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RateDialogManager.showRateDialog(this, savedInstanceState);
    }
}
