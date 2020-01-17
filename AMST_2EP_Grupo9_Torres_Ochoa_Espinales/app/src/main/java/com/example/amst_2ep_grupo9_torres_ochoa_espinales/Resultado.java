package com.example.amst_2ep_grupo9_torres_ochoa_espinales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.List;

public class Resultado extends AppCompatActivity {
    JSONObject busqueda = MainActivity.busqueda;
    private LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        contenedor = findViewById(R.id.cont_heroes);
        try {
            JSONArray l = (JSONArray) busqueda.get("results");
            for (int i  = 0; i < l.length(); i++) {
                JSONObject j = (JSONObject) l.get(i);
                TextView x = new TextView(this);
                x.setText(j.get("id").toString()+", "+j.get("name").toString());
                x.callOnClick();
                contenedor.addView(x);
            }
            TextView t = findViewById(R.id.textResultado);
            t.setText("Resultado: "+l.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void ir(View v) {
        TextView id_heroe = findViewById(R.id.id_heroe);
        String buscar = id_heroe.getText().toString();
        System.out.println(buscar);
        try {
            JSONArray l = (JSONArray) busqueda.get("results");
            for (int i  = 0; i < l.length(); i++) {
                JSONObject j = (JSONObject) l.get(i);
                System.out.println(j.get("id"));
                if (j.get("id").toString() == buscar.toString()) {
                    Intent intent = new Intent(this, GraficoBarras.class);
                    startActivity(intent);
                }
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
