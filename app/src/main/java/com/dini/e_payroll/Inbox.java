package com.dini.e_payroll; // Make sure it's in the same package as MainActivity

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox); // Assuming you have a layout file named "inbox.xml"
    }
    public void inbox(View view) {
    }
}