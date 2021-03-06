package com.example.jonmid.contactosbasededatos.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.R;
import com.example.jonmid.contactosbasededatos.Utilities.Constants;

public class NewCommentActivity extends AppCompatActivity {

    EditText editTexttitle;
    EditText editTextComment;
    SqliteHelper sqliteHelper;
    Integer idContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment);

        editTexttitle= (EditText)  findViewById(R.id.id_et_comment_title);
        editTextComment= (EditText) findViewById(R.id.id_et_comment_comment);

        sqliteHelper= new SqliteHelper(this, "db_contacts", null,1);
        idContact= getIntent().getExtras().getInt("id");
    }

    public  void  createCommment(View view){
        SQLiteDatabase db= sqliteHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constants.TABLA_FIELD_TITLE,editTexttitle.getText().toString());
        values.put(Constants.TABLA_FIELD_COMMENT, editTextComment.getText().toString());
        values.put(Constants.TABLA_FIELD_IDUSER, idContact);
        db.insert(Constants.TABLA_NAME_COMMENTS,Constants.TABLA_FIELD_IDC,values);

        Intent intent= new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
