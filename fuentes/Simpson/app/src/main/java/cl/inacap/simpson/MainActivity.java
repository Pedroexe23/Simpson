package cl.inacap.simpson;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Context context;


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
        queue= Volley.newRequestQueue( this);
         JsonObjectRequest jsonReq;
        cantidades=Integer.parseInt(String.valueOf(opcion.charAt(0)));
        switch (cantidades){
            case 1:
                 jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString("response ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                 queue.add(jsonReq);
                 break;
            case 2:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=2", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 3:
                 jsonReq= new JsonObjectRequest
                         (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=3", null, new Response.Listener<JSONObject>() {
                             @Override
                             public void onResponse(JSONObject response) {
                                 try {
                                     personajes.clear();
                                     Personaje[]arreglo= new Gson().fromJson
                                             (response.getString(" ")
                                                     ,Personaje[].class);
                                     personajes.addAll(Arrays.asList(arreglo));
                                 }catch (Exception ex){
                                     personajes.clear();
                                     Log.e("MainActivity", "Error de consejos");

                                 }finally {
                                     adaptador.notifyDataSetChanged();
                                 }

                             }
                         }, new Response.ErrorListener() {
                             @Override
                             public void onErrorResponse(VolleyError error) {
                                 personajes.clear();
                                 Log.e("MainActivity","Error de respuesta");
                                 adaptador.notifyDataSetChanged();
                             }
                         });
                 queue.add(jsonReq);

            case 4:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=4", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);

            case 5:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=5", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 6:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=6", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 7:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=7", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 8:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=8", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    personajes.clear();
                                    Personaje[]arreglo= new Gson().fromJson
                                            (response.getString(" ")
                                                    ,Personaje[].class);
                                    personajes.addAll(Arrays.asList(arreglo));
                                }catch (Exception ex){
                                    personajes.clear();
                                    Log.e("MainActivity", "Error de consejos");

                                }finally {
                                    adaptador.notifyDataSetChanged();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 9:
                jsonReq= new JsonObjectRequest
                        (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=9", null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                            try {
                                personajes.clear();
                                Personaje[]arreglo= new Gson().fromJson
                                        (response.getString(" ")
                                                ,Personaje[].class);
                                personajes.addAll(Arrays.asList(arreglo));

                            }catch (Exception ex){
                                personajes.clear();
                                Log.e("MainActivity", "Error de consejos");

                            }finally {
                                adaptador.notifyDataSetChanged();
                            }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                personajes.clear();
                                Log.e("MainActivity","Error de respuesta");
                                adaptador.notifyDataSetChanged();
                            }
                        });
                queue.add(jsonReq);
            case 10:
                 jsonReq= new JsonObjectRequest
                         (Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=10", null, new Response.Listener<JSONObject>() {
                             @Override
                             public void onResponse(JSONObject response) {
                                 try {
                                     personajes.clear();
                                     Personaje[]arreglo= new Gson().fromJson
                                             (response.getString(" ")
                                                     ,Personaje[].class);
                                     personajes.addAll(Arrays.asList(arreglo));
                                 }catch (Exception ex){
                                     personajes.clear();
                                     Log.e("MainActivity", "Error de consejos");

                                 }finally {
                                     adaptador.notifyDataSetChanged();
                                 }

                             }
                         }, new Response.ErrorListener() {
                             @Override
                             public void onErrorResponse(VolleyError error) {
                                 personajes.clear();
                                 Log.e("MainActivity","Error de respuesta");
                                 adaptador.notifyDataSetChanged();
                             }
                         });
                queue.add(jsonReq);
            default:
        }

     }


}