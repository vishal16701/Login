package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.password);
        Info = (TextView) findViewById(R.id.info);
        Login = (Button) findViewById(R.id.login);

        Info.setText("No.of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String Name,String Password){
        if((Name.equals("vishal") && (Password.equals("2212"))) || ((Name.equals("kajal") && (Password.equals("0812"))))){
            Intent intent = new Intent(MainActivity.this,secondactivity.class);
            startActivity(intent);
        }
        else{
            count--;
            Info.setText("No. of attempts remaining: " +String.valueOf(count));

            if(count==0){
                Login.setEnabled(false);
            }
        }
    }
}
