package com.example.usuario.estudos;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import static java.util.TimeZone.getDefault;


public class fragment1 extends Fragment {

    private Button btnAgendar;
    private DatePicker dtAgendar;
    private TextView tvAgendar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
              View view =  inflater.inflate(R.layout.fragment1, container, false);

        btnAgendar =(Button)view.findViewById(R.id.btnAgendar);
        dtAgendar = (DatePicker)view.findViewById(R.id.dtAgendar);
        tvAgendar = (TextView)view.findViewById(R.id.tvAgendar);

        dtAgendar.setMinDate(9/2017);


        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ano = dtAgendar.getYear();
                int mes = dtAgendar.getMonth();
                int dia = dtAgendar.getDayOfMonth();
                tvAgendar.setText("Sua consulta foi agendada para o dia: "+dia+"/"+mes+"/"+ano+". ");
            }
        });

        return view;
    }
}

