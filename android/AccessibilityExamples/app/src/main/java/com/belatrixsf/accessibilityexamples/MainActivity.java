package com.belatrixsf.accessibilityexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;
    @BindView(R.id.btnSimpleForm)
    View btnSimpleForm;

    @BindView(R.id.btnDinamicForm)
    View btnDinamicForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.v(TAG, "btnSimpleForm "+btnSimpleForm);
        ui();
    }

    private void ui() {
        btnSimpleForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSimpleForm();
            }
        });
        btnDinamicForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoDynamicForm();
            }
        });
    }

    private void gotoSimpleForm() {
        startActivity(new Intent(this,SimpleFormActivity.class));
    }
    private void gotoDynamicForm() {
        startActivity(new Intent(this,DynamicFormActivity.class));
    }
}
