package br.senai.sp.cotia.todolistapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import br.senai.sp.cotia.todolistapp.R;
import br.senai.sp.cotia.todolistapp.databinding.FragmentInicialBinding;

public class FragmentInicial extends Fragment {

    private FragmentInicialBinding binding;
    //variavel para o datePicker
    DatePickerDialog datePicker;
    // Variaveis para dia mes e ano
    int year, month, day;
    // variavel para a data atual
    Calendar dataAtual;
    //variavel para a data formatada
    String dataEscolida = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicialBinding.inflate(inflater, container, false);
        //instancia o calendar
        dataAtual = Calendar.getInstance();

        //instancia o dia, mês e ano atuais
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        //intancia o DatePicker
        datePicker = new DatePickerDialog(getContext(), (view, ano, mes, dia) -> {
            //cai aqui toda vez que clica no OK do DatePickerDialog

        },year,month,day);

        //lister do botão de data
        binding.btdata.setOnClickListener(v ->{
            datePicker.show();
        } );

        // Inflate the layout for this fragment
        return binding.getRoot();

    }
}