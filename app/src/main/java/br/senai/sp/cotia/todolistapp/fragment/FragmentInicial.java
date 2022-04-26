package br.senai.sp.cotia.todolistapp.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

import br.senai.sp.cotia.todolistapp.R;
import br.senai.sp.cotia.todolistapp.database.AppDatabase;
import br.senai.sp.cotia.todolistapp.databinding.FragmentInicialBinding;
import br.senai.sp.cotia.todolistapp.model.Tarefa;

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
    // variavel para acessar a database
    AppDatabase database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instancia a database
        database = AppDatabase.getDatabase(getActivity());

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
            //passa para as variaveis globais
            year = ano;
            month = mes;
            day = dia;

            //formata a string da dataEscolida
            dataEscolida = String.format("%02d/%02d/%04d", day, month+1, year);
            //joga a String no botão
            binding.btdata.setText(dataEscolida);

        },year,month,day);

        //lister do botão de data
        binding.btdata.setOnClickListener(v ->{
            datePicker.show();
        } );

        //listener do botão salvar
        binding.btsalvar.setOnClickListener(v -> {
            //validar os campos
            if(binding.viewDescricao.getText().toString().isEmpty()){
                binding.viewDescricao.setError("Preencha todos os campos");
                Snackbar.make(binding.viewDescricao, "Informe o titulo", Snackbar.LENGTH_SHORT).show();
            }
            else if(binding.viewTitulo.getText().toString().isEmpty()){
                binding.viewTitulo.setError("Preencha todos os campos");
                Snackbar.make(binding.viewDescricao, "Informe uma descrição", Snackbar.LENGTH_SHORT).show();
            }
            else  if(dataEscolida.isEmpty()){
                Toast.makeText(getContext(), R.string.informe_data, Toast.LENGTH_SHORT).show();
            }else {
                // cria o objeto tarefa
                Tarefa tarefa = new Tarefa();
                // poular a tarefa
                tarefa.setTitulo(binding.viewTitulo.getText().toString());
                tarefa.setDescricao(binding.viewDescricao.getText().toString());
                // cria um calendar e popula cm a data selcionada
                Calendar dataRealizacao = Calendar.getInstance();
                dataRealizacao.set(year,month,day);
                // passar para a tarefa os milisegundos da data
                tarefa.setDataPrevista(dataRealizacao.getTimeInMillis());
                // criar um calendar para a data atual
                Calendar dataAtual = Calendar.getInstance();
                tarefa.setDataCriacao(dataAtual.getTimeInMillis());
                //salvar a tarefa no BD
                new InsertTarefa().execute(tarefa);

            }

        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    // classe para a tesk de inserir Tarefa
    private class InsertTarefa extends AsyncTask<Tarefa, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.w("passou", "no onProgressUpdate");
        }

        @Override
        protected String doInBackground(Tarefa... tarefas) {
            Log.w( "Passou ", "no doInBackground");

            //extrair a tarefa do vetor de tarefas
            Tarefa t = tarefas[0];
            try {
                //retorna ok caso tenha passdo sem erro
                database.getTarefaDao().insert(t);
                return "ok";
            }catch (Exception e){
                // retorna a msg de erro caso tenha dado errado
                e.printStackTrace();
                return e.getMessage();

            }

        }

        @Override
        protected void onPostExecute(String resultado) {
            if(resultado.equals("ok")){
                Log.w("RESULTADO", "IUPIII");
            }else {
                Log.w("RESUTADO", resultado);
            }
            Log.w("passou", "no onPreExecute");
            Toast.makeText(getContext(), "DEU RUIM"+resultado, Toast.LENGTH_SHORT).show();
        }
        }
    }

