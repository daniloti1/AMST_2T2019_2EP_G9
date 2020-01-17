package com.example.amst_2ep_grupo9_torres_ochoa_espinales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue lista = null;
    TextView editText;
    public static JSONObject busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = Volley.newRequestQueue(this);
    }

    public void imprimirResponse(JSONObject response) {
        busqueda = response;
        Intent i = new Intent(this, Resultado.class);
        startActivity(i);
    }

    public void buscarHeroe(View v){
        String url_api = "https://superheroapi.com/api/2979915212042299/search/";

        editText = findViewById(R.id.editText);
        String buscar = editText.getText().toString();
        url_api = String.format("%s%s", url_api, buscar);

        JsonObjectRequest heroes = new JsonObjectRequest(Request.Method.GET, url_api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                imprimirResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

        lista.add(heroes);

    }
}
