package com.monsh.dialphone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class DialActivity extends AppCompatActivity {
    private EditText number;
    private Button call;
    private String num, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        setViews();
        Intent in = getIntent();
        message = in.getStringExtra("Datos");

        number.setText(message);
    }

    public void setViews(){
        number = (EditText)findViewById(R.id.edtNumberD);
        call = (Button)findViewById(R.id.btnCall);
    }

    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void goCall(View view){
        num = number.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.fromParts("tel",num, null));
        startActivity(intent);
    }
}
