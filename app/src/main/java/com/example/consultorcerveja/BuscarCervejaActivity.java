package com.example.consultorcerveja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BuscarCervejaActivity extends AppCompatActivity {

    Spinner spinnerCerveja;
    TextView tvInfos;
    ExpertCerveja expertCerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCerveja = (Spinner) findViewById(R.id.spinnerCerveja);
        tvInfos = (TextView) findViewById(R.id.tvInfos);
        expertCerveja = new ExpertCerveja();

        confSpinner();
    }

    public void findCerveja(View view){

        try {
            String cervejaSelected = spinnerCerveja.getSelectedItem().toString();

            List<String> marcasEncontradas = expertCerveja.getMarcas(cervejaSelected);

            String textMarcas = "";

            for (String marca : marcasEncontradas) {
                textMarcas += marca + "\n";
            }

            tvInfos.setText(textMarcas);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Selecione algum tipo de cerveja...", Toast.LENGTH_SHORT).show();
        }
    }

    private void confSpinner(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cervejas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCerveja.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter,
                        R.layout.contact_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        this));
    }
}
