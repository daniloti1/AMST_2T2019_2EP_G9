package com.example.amst_2ep_grupo9_torres_ochoa_espinales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            buscarHeroe();
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
        v.getId("button_buscar");
        R.id.button_buscar;

         */
    }

    public void buscarHeroe() throws IOException {
        String url_api = "https://superheroapi.com/api/2979915212042299/1";

        JSONObject j = new JSONObject();
        //JsonObjectRequest.Method.GET
        JsonObjectRequest heroes = new JsonObjectRequest(url_api, j,"", new Response.ErrorListener );

        URL url = new URL("https://superheroapi.com/api/2979915212042299/1");
        System.out.println("Antes de la coneccion");
        HttpsURLConnection coneccion = (HttpsURLConnection) url.openConnection();
        System.out.println("Conectado");
        coneccion.setRequestMethod("GET");
        System.out.println("Metodo GET");
        coneccion.connect();
        System.out.println("Conect");
        System.out.println(coneccion.getResponseMessage());
        System.out.println("Mensaje");

    }
}
