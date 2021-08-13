package com.jherrera.myappproductosw.complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {

    public static final String IP_SERVER = "http://192.168.1.6/";

    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }


    public void insertarSW(Context context, String nombre, String descripcion, String categoria,
                           int presio, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/insertar_sw.php?nombre_producto="+nombre+"&descripcion_producto="+descripcion+
                    "&categoria_producto="+categoria+"&presio_producto="+presio;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "Conflicto"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause()+"I--------------"+e.getMessage());
        }

    }

    //Metodo buscar por id
    public void buscarIDSW(Context context, int id, Response.Listener listener,
                           Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw//buscar_id.php?id_producto=" + id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            Toast.makeText(context, "ConflictoB" + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause() + "B--------------" + e.getMessage());
        }
    }

    //metodo consulta
    public void consultaSW(Context context, Response.Listener listener,
                           Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            Toast.makeText(context, "ConflictoC" + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause() + "C--------------" + e.getMessage());
        }
    }
    //metodo eliminar
    public void eliminarSW(Context context, int id, Response.Listener listener,
                           Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/eliminar_sw.php?id_producto=" + id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            Toast.makeText(context, "ConflictoE" + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause() + "E--------------" + e.getMessage());
        }
    }
    //metodo actualizar
    public void actualizarSW(Context context, int id, String nombre, String descripcion, String categoria,
                             int presio, Response.Listener listener,
                             Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/actualizar_sw.php?id_producto="+id+"&nombre_producto="+nombre+
                    "&descripcion_producto="+descripcion+"&categoria_producto="+categoria+"&presio_producto="+presio;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            Toast.makeText(context, "ConflictoA" + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause() + "A--------------" + e.getMessage());
        }
    }
}

