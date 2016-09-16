package com.belatrixsf.accessibilityexamples;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.belatrixsf.accessibilityexamples.model.Field;
import com.belatrixsf.accessibilityexamples.model.FormType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DynamicFormActivity extends AppCompatActivity {

    private static final String TAG = "DinamicFormA";
    @BindView(R.id.llayContainer)
    LinearLayout llayContainer;

    private List<Field> fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_form);
        ButterKnife.bind(this);
        mock();
        setupUI();
    }

    private void mock() {
        fields= new ArrayList<>();
        fields.add(new Field(1, FormType.label,"Belatrix", "Bealtrix"));
        fields.add(new Field(2, FormType.email,"Email", "Email"));
        fields.add(new Field(3, FormType.number,"Number", "Number"));
        fields.add(new Field(4, FormType.password,"Password", "Password"));
        fields.add(new Field(5, FormType.text,"Text", "Text"));
        fields.add(new Field(6, FormType.label,"Belatrix", "Belatrix"));
        fields.add(new Field(7, FormType.text,"Text", "Text"));
    }

    private void setupUI() {

        LayoutInflater inflate =(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=null;

        TextView textView=null;
        int count =0;
        for (Field field:fields) {

            Log.v(TAG, "field type "+field.getType()+ " desc "+field.getDescription());
            if(field.getType().equals(FormType.label)){
                view= inflate.inflate(R.layout.row_form_label,null);
                textView= (AppCompatTextView) view.findViewById(R.id.tviField);
                textView.setText(field.getValue());
                textView.setContentDescription(field.getDescription());
                textView.setImeOptions(EditorInfo.IME_ACTION_NEXT);

            }else{
                int inputType= InputType.TYPE_CLASS_TEXT;
                int imeOptions= EditorInfo.IME_ACTION_NEXT;
                if(count>= (fields.size()-1))imeOptions= EditorInfo.IME_ACTION_DONE;
                if(field.getType().equals(FormType.password))inputType=  InputType.TYPE_TEXT_VARIATION_PASSWORD;
                if(field.getType().equals(FormType.email))inputType=  InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
                if(field.getType().equals(FormType.number))inputType=  InputType.TYPE_CLASS_NUMBER;

                view= inflate.inflate(R.layout.row_form_input,null);
                textView= (AppCompatEditText) view.findViewById(R.id.eteField);
                textView.setHint(field.getValue());
                textView.setContentDescription(field.getDescription());
                textView.setInputType(InputType.TYPE_CLASS_TEXT | inputType);
                textView.setImeOptions(imeOptions);
            }
            if(view!=null) llayContainer.addView(view);

            count ++;
        }

    }
}
