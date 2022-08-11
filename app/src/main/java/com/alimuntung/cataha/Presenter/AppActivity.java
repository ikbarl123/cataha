package com.alimuntung.cataha.Presenter;

import android.os.Bundle;

import com.alimuntung.cataha.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.alimuntung.cataha.databinding.ActivityAppBinding;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class AppActivity extends AppCompatActivity {
    // Ikbar Laudza Alviansyah
// IF-7
// 10119260
    private ActivityAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (!getPackageName().equals("co"+"m.alimu"+"ntung.cat"+"aha")){
            System.exit(0);
        }
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_catatan, R.id.navigation_profil, R.id.navigation_info)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_app);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}