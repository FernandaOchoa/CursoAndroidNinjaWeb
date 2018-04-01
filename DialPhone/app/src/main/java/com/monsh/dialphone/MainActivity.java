package com.monsh.dialphone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnGo;
    private EditText data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    public void setViews(){
        btnGo = (Button) findViewById(R.id.btnGo);
        data = (EditText)findViewById(R.id.edtNumber);
    }

    public void goTo(View view){
        Intent i = new Intent(this, DialActivity.class);

        //Paso de parametros
        String datos = data.getText().toString();
        i.putExtra("Datos",datos);
        hideKeyboard(view);
        startActivity(i);
    }

    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
