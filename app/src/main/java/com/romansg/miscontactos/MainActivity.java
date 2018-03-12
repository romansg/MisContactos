package com.romansg.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContactos = findViewById(R.id.rvContactos);

        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        rvContactos.setLayoutManager(llm);*/
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rvContactos.setLayoutManager(glm);

        inicializarContactos();
        inicializarAdaptador();
    }

    public void inicializarContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.flower,"Liliana", "5544845855", "liliana@gmail.com"));
        contactos.add(new Contacto(R.drawable.banana,"Román", "5526999144", "roman@gmail.com"));
        contactos.add(new Contacto(R.drawable.diamond,"Abuela", "7775117926", "abuela@gmail.com"));
        contactos.add(new Contacto(R.drawable.robot, "Rosa", "5510683659", "rosa@gamil.com"));
        contactos.add(new Contacto(R.drawable.mushroom, "Fito", "2288334684", "fito@gmail.com"));
        contactos.add(new Contacto(R.drawable.hot_chili, "Bruno", "56668011","bruno@gmail.com"));
        contactos.add(new Contacto(R.drawable.freaky_head, "Guest", "666","guest@gmail.com"));
    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        rvContactos.setAdapter(adaptador);
    }
}
