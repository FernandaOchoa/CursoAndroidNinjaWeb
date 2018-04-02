package com.monsh.book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.monsh.book.Model.Book;
import com.monsh.book.Sqlite.MySqliteHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySqliteHelper db = new MySqliteHelper(this);


        db.addBook(new Book("Android Programming: The Big Nerd Ranch", "Kristin Mariskano"));
        db.addBook(new Book("Curso de Programacion Android","Jose Dimas Lujan"));
        db.addBook(new Book("Java 2 Curso de Programacion", "Fco Javier Ceballos"));

        List <Book> list = db.getAllBooks();

        db.deleteBook(list.get(2));

        db.getAllBooks();
    }
}
