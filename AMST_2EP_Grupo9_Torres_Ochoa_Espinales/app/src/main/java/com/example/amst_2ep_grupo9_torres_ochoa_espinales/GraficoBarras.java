package com.example.amst_2ep_grupo9_torres_ochoa_espinales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;

public class GraficoBarras extends AppCompatActivity {

    public BarChart graficoBarras;
    private RequestQueue ListaRequest = null;
    private String token = "eyJ0eXAi………………………-mMIArvMc";
    private GraficoBarras context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_barras);
        setTitle("Grafico de barras");
        ListaRequest = Volley.newRequestQueue(this);
        context = this;
        this.iniciarGrafico();
        this.solicitarHabilidades();
    }

    public void iniciarGrafico() {
        graficoBarras = findViewById(R.id.barChart); //???
        graficoBarras.getDescription().setEnabled(false);
        graficoBarras.setMaxVisibleValueCount(60);
        graficoBarras.setPinchZoom(false);
        graficoBarras.setDrawBarShadow(false);
        graficoBarras.setDrawGridBackground(false);
        XAxis xAxis = graficoBarras.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        graficoBarras.getAxisLeft().setDrawGridLines(false);
        graficoBarras.animateY(1500);
        graficoBarras.getLegend().setEnabled(false);
    }

    public void solicitarHabilidades() {

    }
}
