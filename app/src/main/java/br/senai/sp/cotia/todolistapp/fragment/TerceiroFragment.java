package br.senai.sp.cotia.todolistapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.todolistapp.R;
import br.senai.sp.cotia.todolistapp.databinding.FragmentTerceiroBinding;


public class TerceiroFragment extends Fragment {

    private FragmentTerceiroBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTerceiroBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}