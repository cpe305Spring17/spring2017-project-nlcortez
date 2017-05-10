package com.example.natasha.bookkeepingbuddy.view;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingContract;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingDbHelper;

public class MainActivity extends AppCompatActivity {
  private SQLiteDatabase bookkeepingDB;

  private EditText mNewCategoryNameEditText;
  private EditText mNewUnitEditText;
  private Button mBtnAddCategory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mNewCategoryNameEditText = (EditText) findViewById(R.id.cat_name_edit_text);
    mNewUnitEditText = (EditText) findViewById(R.id.cat_unit_edit_text);
    mBtnAddCategory = (Button) findViewById(R.id.save_button);

    BookkeepingDbHelper dbHelper = new BookkeepingDbHelper(this);
    bookkeepingDB = dbHelper.getWritableDatabase();

    addToBook();
  }

  public void addToBook() {
    mBtnAddCategory.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                String category = mNewCategoryNameEditText.getText().toString();
                String unit = mNewUnitEditText.getText().toString();

                addNewCategory(category, unit);

                Toast.makeText(MainActivity.this,
                               R.string.category_added_toast,
                               Toast.LENGTH_SHORT).show();
              }
            }
    );
  }

  private long addNewCategory(String name, String unit) {
    ContentValues cv = new ContentValues();

    cv.put(BookkeepingContract.CategoryEntry.COLUMN_CATEGORY_NAME, name);
    cv.put(BookkeepingContract.CategoryEntry.COLUMN_UNIT, unit);

    return bookkeepingDB.insert(BookkeepingContract.CategoryEntry.TABLE_NAME, null, cv);
  }
}
