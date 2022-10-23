package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proyectomovil.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //fragment que se mostrara cuando inicia la app
        replaceFragment(new InicioFragment());


    //cuando seleccionemos un objeto del nav obtiene su id y por medio de el accede al fragment(vista para el nav)
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch(item.getItemId()){
                case R.id.menu:
                    replaceFragment(new InicioFragment());
                    break;
                case R.id.mensajeria:
                    replaceFragment(new MensajeriaFragment());
                    break;
                case R.id.perfil:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });

    }
    //remplazar el framelayout por los fragments
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}