package com.romansg.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Liliana", "5544845855", "liliana@gmail.com"));
        contactos.add(new Contacto("Román", "5526999144", "roman@gmail.com"));
        contactos.add(new Contacto("Abuela", "7775117926", "abuela@gmail.com"));
        contactos.add(new Contacto("Rosa", "5510683659", "rosa@gamil.com"));
        contactos.add(new Contacto("Fito", "2288334684", "fito@gmail.com"));
        contactos.add(new Contacto("Bruno", "56668011","bruno@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());

                startActivity(intent);
            }
        });
    }
}
