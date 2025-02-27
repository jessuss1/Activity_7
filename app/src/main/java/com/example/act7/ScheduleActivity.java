package com.example.act7;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.act7.databinding.ActivityScheduleBinding;


public class ScheduleActivity extends AppCompatActivity {


    private String[] maestrosRedes;
    private String[] materiasRedes;
    private String[] maestrosProgramacion;
    private String[] materiasProgramacion;
    String name;
    String fase;
    int selectedIndex;

    private ActivityScheduleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.schedule, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = getIntent().getStringExtra("name");
        fase = getIntent().getStringExtra("fase");
        selectedIndex = getIntent().getIntExtra("selectedIndex", 0);

        binding.displayNameTextView.setText("Nombre:\n" +name);
        binding.displayFaseTextView.setText("Fase:\n"+fase);

        // Si el index = 1 or 2 es estudiante de programacion, si es 3 or 4 es estudiante de redes
        // Si el index es 0 (valor default) no se paso o recibio el index correctamente
        if (selectedIndex == 1 || selectedIndex == 2){

            //Los arrays estan en res/values/strings.xml
            materiasProgramacion = getResources().getStringArray(R.array.materiasProgramacion);
            maestrosProgramacion = getResources().getStringArray(R.array.maestrosProgramacion);

            for (int i = 0; i < maestrosProgramacion.length; i++){
                    int tableRow = getResources().getIdentifier("row"+i, "id", getPackageName());
                    //Obtenemos el id en integers del los TextView objetivo y los asignamos a maestroTextView
                    int maestroTextView = getResources().getIdentifier("maestro"+i, "id", getPackageName());
                    //Buscamos los TextView con el id que se guarda en maestroTextView
                    TextView maestroTV = binding.getRoot().findViewById(maestroTextView);

                    int materiaTextView = getResources().getIdentifier("materia"+i, "id", getPackageName());
                    TextView materiaTV =  binding.getRoot().findViewById(materiaTextView);

                    //Para prevenir que la aplicacion se cierre en caso de que algun id sea null
                if (maestroTV != null && materiaTV != null){
                    //colorea una linea si y una no
                    if (i % 2 == 0) {
                        binding.getRoot().findViewById(tableRow).setBackgroundColor(Color.argb(25, 0, 122, 255));
                        }
                        maestroTV.setText(maestrosProgramacion[i]);
                        materiaTV.setText(materiasProgramacion[i]);
                    }

            }

            } else if (selectedIndex == 3 || selectedIndex == 4 ){

            maestrosRedes = getResources().getStringArray(R.array.maestrosRedes);
            materiasRedes = getResources().getStringArray(R.array.materiasRedes);

            for (int i = 0; i < maestrosRedes.length; i++){
                int tableRow = getResources().getIdentifier("row"+i, "id", getPackageName());

                int maestroTextView = getResources().getIdentifier("maestro"+i, "id", getPackageName());
                TextView maestroTV = binding.getRoot().findViewById(maestroTextView);

                int materiaTextView = getResources().getIdentifier("materia"+i, "id", getPackageName());
                TextView materiaTV = binding.getRoot().findViewById(materiaTextView);

                if (maestroTV != null && materiaTV != null){
                    if (i % 2 == 0) {
                        binding.getRoot().findViewById(tableRow).setBackgroundColor(Color.argb(25, 0, 122, 255));
                    }
                    maestroTV.setText(maestrosRedes[i]);
                    materiaTV.setText(materiasRedes[i]);
                }

            }

        } else {
            Toast.makeText(this, "The selected index was" +selectedIndex+ "!", Toast.LENGTH_LONG ).show();
        }





    }
}
