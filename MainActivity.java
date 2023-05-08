package com.example.ceres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new principal(), "Principal");
        vpAdapter.addFragment(new relatorios(),"Relatórios");
        vpAdapter.addFragment(new dispositivos(),"Dispositivos");
        viewPager.setAdapter(vpAdapter);

    }

    private class dataRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {
            return espGetData.getData(url[0]);
        }

        @Override
        protected void onPostExecute(String result) { //função para tratar dados retornados
            if (result != null){
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show(); // toast na main activity layout mostrando o dado obtido
            }else{
                Toast.makeText(MainActivity.this, "Falha na requisição de dados", Toast.LENGTH_LONG).show();
            }
        }
    }
}