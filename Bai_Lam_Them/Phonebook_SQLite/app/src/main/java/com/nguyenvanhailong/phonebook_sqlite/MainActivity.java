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

                //?????t h???p dialog_contact_details.xml th??nh tr??nh t???o alertdialog
                alertDialogBuilder.setView(getEmpIdView);

                final EditText nameInput = (EditText) getEmpIdView.findViewById(R.id.editTextDialogNameInput);
                final EditText phoneInput = (EditText) getEmpIdView.findViewById(R.id.editTextDialogPhoneInput);
                // ?????t th??ng b??o h???p tho???i

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Th??m", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // l???y ?????u v??o c???a ng?????i d??ng v?? ?????t n?? th??nh k???t qu???
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
        Toast.makeText(this, "T???o li??n h???" + contactName, Toast.LENGTH_LONG).show();
    }

    private void deleteAllContacts() {

        getContentResolver().delete(ContactsProvider.CONTENT_URI, null, null);
        restartLoader();
        Toast.makeText(this, "T???t c??? ?????a ch??? li??n h??? ???? b??? x??a", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // L??m n???i v??ng menu - ??i???u n??y s??? th??m c??c m???c v??o thanh t??c v??? n???u menu ???????c s??? d???ng.
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

    //Kh???i ?????ng l???i m???t Loader hi???n c?? v???i id c??? th???
    private void restartLoader() {
        getLoaderManager().restartLoader(0, null, this);
    }

    //C??c ph????ng th???c n??y ???????c t??? ?????ng k??ch ho???t, ch???y trong m???t chu???i ri??ng bi???t, t???i d??? li???u t??? tr??nh cung c???p v?? tr??? v??? m???t Loader m???i cho id ???? cho
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, ContactsProvider.CONTENT_URI, null, null, null, null);
    }

    //Ph????ng th???c n??y ???????c g???i khi m???t Loader ???????c t???o tr?????c ???? ???? ho??n th??nh qu?? tr??nh t???i c???a n??.
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

    //Ph????ng th???c n??y ???????c g???i khi m???t Loader ???????c t???o tr?????c ???? ??ang ???????c ?????t l???i v?? do ???? l??m cho d??? li???u c???a n?? kh??ng kh??? d???ng.
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}