package cl.inacap.simpson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.simpson.adaptadores.PersonajesAdapter;
import cl.inacap.simpson.dto.Personaje;

public class MainActivity extends AppCompatActivity {
    private Spinner consejosSp;
    private Button solicitarConsejoBtn;
    private ListView listaPersonajesLv;
    private List<Personaje> personajes=new ArrayList<>();
    private PersonajesAdapter adaptador;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        consejosSp=(Spinner)findViewById(R.id.consejosSp);
        solicitarConsejoBtn=(Button)findViewById(R.id.solicitarConsejoBtn);
        String [] CantConsejos={"1 frase","2 frases","3 frases","4 frases","5 frases","6 frases","7 frases","8 frases","9 frases","10 frases"};
        ArrayAdapter <String> consejosadapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CantConsejos);
        consejosSp.setAdapter(consejosadapter);
        solicitarConsejoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String opcion=consejosSp.getSelectedItem().toString();
                consejos(opcion);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        getPersonajes();
        adaptador= new PersonajesAdapter(this, R.layout.list_personajes, getPersonajes());
        listaPersonajesLv=findViewById(R.id.listaPersonajesLv);
        listaPersonajesLv.setAdapter(adaptador);
    }
     private List<Personaje>getPersonajes(){
         return personajes;

     }

     private void consejos ( String opcion ){
        int  cantidades=0;

        cantidades=Integer.parseInt(String.valueOf(opcion.charAt(0)));
        switch (cantidades){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            default:
        }

     }
}