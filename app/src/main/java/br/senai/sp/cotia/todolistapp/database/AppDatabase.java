package br.senai.sp.cotia.todolistapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.senai.sp.cotia.todolistapp.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //atributo para acessar a dATA BASE
    private static  AppDatabase database;
    // metodo para Tarefadao
    public abstract TarefaDao getTarefaDao();

    // metodo para acessar o atrbuto que acessa a database
    public static AppDatabase getDatabase(Context context){
        // verifica se não foi instanciado
        if(database == null){
            // instancia a database
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "To do list").build();
        }

        // retorna a database
        return database;
    }
}
