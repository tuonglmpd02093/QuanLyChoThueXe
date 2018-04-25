package com.example.pc.quanlychothuexe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.quanlychothuexe.DBManager.CustomAdapter;
import com.example.pc.quanlychothuexe.DBManager.DBManager;
import com.example.pc.quanlychothuexe.DBManager.KhachHang;

import java.util.List;

public class QLCTX1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EditText edCode, edName, edEmail, edPhone, edAddress, edXe, edBiensoxe, edMauxe;
    private Button btAdd, btDelete, btListView, btEdit;
    private DBManager dbManager;
    private List<KhachHang> list;
    CustomAdapter customAdapter;
    ListView lvManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlctx1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
                        .setAction("Action" , null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this , drawer , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Init();

        dbManager = new DBManager(this);
        list = dbManager.getAllKhachHang();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang khachHang = createKH();
                if (khachHang!=null){
                    dbManager.addKhachHang(khachHang);
                    Toast.makeText(getApplicationContext()
                            ,"Add Employees Successfuly",Toast.LENGTH_SHORT).show();
                }
                list.clear();
                list.addAll(dbManager.getAllKhachHang());

            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edCode.setText("");
                edName.setText("");
                edEmail.setText("");
                edPhone.setText("");
                edAddress.setText("");
                edXe.setText("");
                edBiensoxe.setText("");
                edMauxe.setText("");
            }
        });
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLCTX1.this,DanhSachActivity.class);
                startActivity(intent);
            }
        });
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLCTX1.this,DanhSachActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext()
                        ,"Choose Employees",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.qlctx1 , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_listKH) {
            Intent intent = new Intent(QLCTX1.this, DanhSachActivity.class);
            startActivity(intent);
            //  list khách hàng action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private KhachHang createKH(){
        String code = edCode.getText().toString();
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String phone = edPhone.getText().toString();
        String address = edAddress.getText().toString();
        String xe = edXe.getText().toString();
        String biensoxe = edBiensoxe.getText().toString();
        String mauxe = edMauxe.getText().toString();

        KhachHang khachHang = new KhachHang(code,name,email,phone,address,xe,biensoxe,mauxe);
        return khachHang;
    }
    public void Init(){
        edCode = (EditText) findViewById(R.id.edCode);
        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edAddress = (EditText) findViewById(R.id.edAddress);
        edXe = (EditText) findViewById(R.id.edXe);
        edBiensoxe = (EditText) findViewById(R.id.edBiensoxe);
        edMauxe = (EditText) findViewById(R.id.edMauxe);
        btAdd = (Button) findViewById(R.id.btAdd);
        btDelete = (Button) findViewById(R.id.btDelete);
        btListView = (Button) findViewById(R.id.btList);
        btEdit = (Button) findViewById(R.id.btEdit);

    }
}
