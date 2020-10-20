package com.gonzalo.mascotas5.activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import com.guillermo.mascotas5.Fragments.FraPerfilMascota;
import com.guillermo.mascotas5.Fragments.FraReciclerview;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.adapters.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        //Toolbar
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_bar);
//        setSupportActionBar(myToolbar);
//        getSupportActionBar().setTitle("Petagram inicio");

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FraReciclerview());
        fragments.add(new FraPerfilMascota());

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_huella);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
            case R.id.mAbout:
                Intent intentAcercade = new Intent(this, AcercadeActivity.class);
                startActivity(intentAcercade);
                break;
            case R.id.mFavoritos:
                Intent intent = new Intent(this, Favorito.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}