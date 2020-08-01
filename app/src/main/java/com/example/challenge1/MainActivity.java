package com.example.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText address;
    private EditText pass;
    private EditText rePass;
    private Button save;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.editName);
        email= findViewById(R.id.editEmail);
        address= findViewById(R.id.editAddress);
        pass= findViewById(R.id.editPass);
        rePass= findViewById(R.id.editRePass);
        save= findViewById(R.id.buttonSave);
        checkBox= findViewById(R.id.checkLicence);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email_address= email.getText().toString();
                Pattern p = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(email_address);

                if("".equals(name.getText().toString()))
                    Toast.makeText(MainActivity.this, "Please enter your name"+name.getText(), Toast.LENGTH_SHORT).show();

                else if(!m.matches())
                    Toast.makeText(MainActivity.this, "Please enter a valid email id", Toast.LENGTH_SHORT).show();

                else if(!pass.getText().toString().equals(rePass.getText().toString()))
                    Toast.makeText(MainActivity.this, "Password don't match. PLEASE try again!", Toast.LENGTH_SHORT).show();

                else if("".equals(address.getText().toString()))
                    Toast.makeText(MainActivity.this, "Please enter your address", Toast.LENGTH_SHORT).show();

                else if(!checkBox.isChecked())
                    Toast.makeText(MainActivity.this, "Please agree with our terms and conditions", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();



            }
        });


    }
}