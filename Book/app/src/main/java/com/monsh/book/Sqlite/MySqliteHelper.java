package com.monsh.book.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.monsh.book.Model.Book;

import java.util.LinkedList;
import java.util.List;

public class MySqliteHelper  extends SQLiteOpenHelper{

    //Database version
    private static final int DATABASE_VERSION =1;

    //Database nombre
    private static final String DATABASE_NAME ="BookDB";

    //CRUD CONSTANTS
    //Books table name
    private static final String TABLE_BOOKS = "books";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};

    public MySqliteHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL para crear la tabla book
        String CREATE_BOOK_TABLE = "CREATE TABLE books ( "+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "title TEXT, "+
                "author TEXT)";
        //Crear la tabla
        db.execSQL(CREATE_BOOK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Elimine las tablas anteriores si es que existen
        db.execSQL("DROP TABLE IF EXISTS books");

        // creamos una tabla nueva
        this.onCreate(db);

    }

    //CRUD OPERATIONS

    //Add a book

    public void addBook(Book book){
        //logg
        Log.d("addBook", book.toString());

        //1 obtenemos la referncia DB Write
        SQLiteDatabase db = this.getWritableDatabase();

        //2 Content values para añadir en la columna un valor
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_AUTHOR, book.getAuthor());

        // 3 Insertar
        db.insert(TABLE_BOOKS,null,values);

        // Cerrar
        db.close();
    }

    // Get Book
    public Book getBook(int id){
        //Obtenemos la referencia lectura
        SQLiteDatabase db = this.getReadableDatabase();

        //query
        Cursor cursor =
                db.query(TABLE_BOOKS, // a. tabla
                        COLUMNS, // b. nombres columnas
                        " id = ?", // c. selection
                        new String[] { String.valueOf(id) }, // d. selection args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we ot results get the first
        if(cursor!= null)
            cursor.moveToFirst();

        // build book object
        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setTitle(cursor.getString(1));
        book.setAuthor(cursor.getString(2));

        //Log
        Log.d("getBook("+id+")",book.toString());

        //return book
        return book;
    }

    //Get All Books
    public List<Book> getAllBooks(){
        List<Book> books = new LinkedList<Book>();

        // construir el query
        String query = "SELECT * FROM "+TABLE_BOOKS;

        //Referencia de escritura
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        // iterar y agregar
        Book book = null;
        if (cursor.moveToFirst()){
            do{
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                books.add(book);

            } while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", books.toString());
        //return books
        return books;
    }


    //Update single book
    public int updateBook(Book book){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title",book.getTitle());
        values.put("author",book.getAuthor());

        int i = db.update(TABLE_BOOKS,
                values,
                KEY_ID+"=?",
                new String[]{String.valueOf(book.getId())});
        db.close();

        return i;
    }

    //Delete a single book
    public void deleteBook (Book book){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_BOOKS,
                KEY_ID+"=?",
                new String[]{String.valueOf(book.getId())});

        db.close();

        Log.d("deleteBook",book.toString());
    }
}
