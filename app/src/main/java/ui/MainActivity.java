package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

//import algonquin.cst2335.li000772.databinding.ActivityMainBinding;
//import algonquin.cst2335.torunse.R;
import algonquin.cst2335.torunse.databinding.ActivityMainBinding;
//import algonquin.cst2335.torunse.databinding.ActivityMainBinding;
import data.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    private ActivityMainBinding variableBinding;


    //private ActivityMainBinding variableBinding;
    //private ActivityMainBinding ViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());

        variableBinding.switch1.setOnCheckedChangeListener( (button, isSelected) -> {
            model.isSelected.postValue(isSelected);

        });
        variableBinding.checkBox.setOnCheckedChangeListener((button, isSelected) -> {
            model.isSelected.postValue(isSelected);

        });
        variableBinding.radioButton.setOnCheckedChangeListener( (button, isSelected) -> {
            model.isSelected.postValue(isSelected);

        });

        model.isSelected.observe(this, selected -> {

            variableBinding.switch1.setChecked(selected);
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);

            Toast.makeText(this,"now the value is:" + selected,Toast.LENGTH_LONG).show();
        });


        setContentView(variableBinding.getRoot());

        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });

        model.editString.observe(this,s ->{
            variableBinding.myedittext.setText("Your edit text has:" + s);

        });

        variableBinding.myimageButton.setOnClickListener(click ->
                Toast.makeText(this,"The width = " + click.getWidth()+ " and height = " + click.getHeight(),Toast.LENGTH_LONG).show());
    }
}