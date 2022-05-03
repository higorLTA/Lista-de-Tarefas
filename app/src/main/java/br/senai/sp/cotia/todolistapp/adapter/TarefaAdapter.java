package br.senai.sp.cotia.todolistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.senai.sp.cotia.todolistapp.R;
import br.senai.sp.cotia.todolistapp.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {


        //Lista de tarefas
        private List<Tarefa> tarefas;
        // variavel para o context
        private Context context;


    // Criando um contrutor para receber a lista
    public TarefaAdapter(List<Tarefa> lista, Context contexto) {
        this.tarefas = lista;
        this.context = contexto;
    }


        @NonNull
        @Override
        public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // infla o layout do adaptaer
            View view = LayoutInflater.from(context).inflate(R.layout.layout_tarefa, parent, false);
            // Retorna um novo viewHoder com  a view
            return new TarefaViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {

            // Obtem a tarefa pela position
            Tarefa t = tarefas.get(position);
            holder.tvTitulo.setText(t.getTitulo());
            //se estiver concluida
            if(t.isCocluida()){
                holder.tvStatus.setText("Concluida");
                holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
            }else{
                holder.tvStatus.setText("Aberta");
                holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.yellow));
            }

            //Formata a data de long pra string
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            holder.data.setText(formatador.format(t.getDataPrevista()));
        }

        // Retorna a quantidade de elementos a serem exibidos na lista
        @Override
        public int getItemCount() {
             if(tarefas != null){
                return tarefas.size();
            }
             return 0;
        }

    class TarefaViewHolder extends RecyclerView.ViewHolder{
        // variaveis para acessar os componentes do xml
        TextView tvTitulo, data, tvStatus;

        public TarefaViewHolder(View view){
            // chama o construtor da super classe
            super(view);
            // passar para as variaveis, os componentes do xml
            tvTitulo = view.findViewById(R.id.tvTitulo);
            data = view.findViewById(R.id.date);
            tvStatus = view.findViewById(R.id.tvStatus);

        }

    }
}
