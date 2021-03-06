package br.senai.sp.cotia.todolistapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private  long dataCriacao;
    private  long dataFinalizacao;
    private long dataPrevista;

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public long getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(long dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public long getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(long dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    //Informa se a tarefas esta concluida
    public boolean isCocluida(){
        return dataFinalizacao != 0;
    }
}
