package br.senai.sp.cotia.todolistapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

import br.senai.sp.cotia.todolistapp.R;
import br.senai.sp.cotia.todolistapp.databinding.FragmentSegundoBinding;
import br.senai.sp.cotia.todolistapp.databinding.FragmentTerceiroBinding;

public class SegundoFragment extends Fragment {

    private FragmentSegundoBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSegundoBinding.inflate(inflater, container, false);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}