package com.nguyenvanhailong.phonebook_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ContactsAdapter adapter;
    RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv_list = (RecyclerView) findViewById(R.id.contact_list);
        rv_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_list.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getLoaderManager().initLoader(0, null, this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View getEmpIdView = li.inflate(R.layout.dialog_contact_details, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                //đặt hộp thoại_contact_details.xml thành trình tạo alertdialog
                alertDialogBuilder.setView(getEmpIdView);

                final EditText nameInput = (EditText) getEmpIdView.findViewById(R.id.editTextDialogNameInput);
                final EditText phoneInput = (EditText) getEmpIdView.findViewById(R.id.editTextDialogPhoneInput);
                // đặt thông báo hộp thoại

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // lấy đầu vào của người dùng và đặt nó thành kết quả
                                insertContact(nameInput.getText().toString(), phoneInput.getText().toString());
                                restartLoader();

                            }
                        }).create()
                        .show();

            }
        });
    }


    private void insertContact(String contactName, String contactPhone) {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.CONTACT_NAME, contactName);
        values.put(SQLiteHelper.CONTACT_PHONE, contactPhone);
        Uri contactUri = getContentResolver().insert(ContactsProvider.CONTENT_URI, values);
        Toast.makeText(this, "Tạo liên hệ" + contactName, Toast.LENGTH_LONG).show();
    }

    private void deleteAllContacts() {

        getContentResolver().delete(ContactsProvider.CONTENT_URI, null, null);
        restartLoader();
        Toast.makeText(this, "Tất cả địa chỉ liên hệ đã bị xóa", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Làm nổi vùng menu - điều này sẽ thêm các mục vào thanh tác vụ nếu menu được sử dụng.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.deleteAllContacts:
                deleteAllContacts();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Khởi động lại một Loader hiện có với id cụ thể
    private void restartLoader() {
        getLoaderManager().restartLoader(0, null, this);
    }

    //Các phương thức này được tự động kích hoạt, chạy trong một chuỗi riêng biệt, tải dữ liệu từ trình cung cấp và trả về một Loader mới cho id đã cho
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, ContactsProvider.CONTENT_URI, null, null, null, null);
    }

    //Phương thức này được gọi khi một Loader được tạo trước đó đã hoàn thành quá trình tải của nó.
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        List<Contact> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(SQLiteHelper.CONTACT_NAME);
            int index2 = cursor.getColumnIndex(SQLiteHelper.CONTACT_PHONE);
            String name = cursor.getString(index1);
            String phone_no = cursor.getString(index2);

            Contact contact = new Contact(name, phone_no);
            list.add(contact);
        }

        adapter = new ContactsAdapter(this, list);
        rv_list.setAdapter(adapter);

    }

    //Phương thức này được gọi khi một Loader được tạo trước đó đang được đặt lại và do đó làm cho dữ liệu của nó không khả dụng.
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}