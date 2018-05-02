package com.robynandcory.frankasflowers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * Intent opens email app when address button is clicked
     * @param view Send My Order button
     */
    public void sendEmailIntent(View view) {
    Intent sendOrder = new Intent(Intent.ACTION_SENDTO);
         sendOrder.setType("text/plain");
         sendOrder.setData(Uri.parse("mailto:Franka@fflowers.biz"));
    //user to select email app
         sendOrder.putExtra(Intent.EXTRA_SUBJECT, "My Flower Order");
        if (sendOrder.resolveActivity(getPackageManager()) != null) {
            startActivity(sendOrder);
        } else {
            Toast.makeText(MainActivity.this, "Please install an email app to send an order.", Toast.LENGTH_LONG).show();
        }
}
}
