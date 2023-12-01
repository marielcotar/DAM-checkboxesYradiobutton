package com.example.steph2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
/*
* Checar documentación oficial de android developers sobre el uso de checkbox y radio button

https://developer.android.com/develop/ui/views/components/checkbox

https://developer.android.com/develop/ui/views/components/radiobutton

Creen una activity en la que pongan 3 opciones para checkbox relacionadas con comidas por ejemplo:
*  Sushi, Pizza, Hamburguesa, pongan también 2 opciones para radiobutton y pongan tipos de salsa.
* Implementen el evento OnCheckedChangeListener y pongan un mensaje.
*
* */

public class MainActivity extends AppCompatActivity {
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultado);
        CheckBox checkboxSushi = findViewById(R.id.checkBoxSushi);
        CheckBox checkboxHamburguesa = findViewById(R.id.checkBoxHamburguesa);
        CheckBox checkboxPizza = findViewById(R.id.checkBoxPizza);
        RadioGroup radioGroupSalsas = findViewById(R.id.radioGroupSalsas);

        checkboxSushi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                actualizarResultado();
            }
        });
        checkboxPizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                actualizarResultado();
            }
        });
        checkboxHamburguesa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                actualizarResultado();
            }
        });
        radioGroupSalsas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                actualizarResultado();
            }
        });
    }
    private void actualizarResultado(){
        CheckBox checkboxSushi = findViewById(R.id.checkBoxSushi);
        CheckBox checkboxHamburguesa = findViewById(R.id.checkBoxHamburguesa);
        CheckBox checkboxPizza = findViewById(R.id.checkBoxPizza);
        RadioGroup radioGroupSalsas = findViewById(R.id.radioGroupSalsas);

        StringBuilder msg  = new StringBuilder("Resultado: ");
        if(checkboxPizza.isChecked()){
            msg.append("Pizza, ");
        }
        if(checkboxSushi.isChecked()){
            msg.append("Sushi, ");
        }
        if(checkboxHamburguesa.isChecked()){
            msg.append("Hamburguesa, ");
        }

        int selectedRadio = radioGroupSalsas.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedRadio);

        if (radioButton!= null){
            msg.append("Salsa: ").append(radioButton.getText());
        }
        textViewResultado.setText(msg.toString());
    }
}