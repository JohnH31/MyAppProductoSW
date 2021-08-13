package com.jherrera.myappproductosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappproductosw.complementos.MetodosSW;
import com.jherrera.myappproductosw.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ProductoVO> listaProductoVO;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_sw);
        listView = findViewById(R.id.lvListasProducto);
        metodosSW.consultaSW(this,this,this);
    }
    private void resultadoConsultaCompleta(JSONObject response){
        ProductoVO productoVO;
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        listaProductoVO = new ArrayList<>();
        try {
            for(int i=0;i<jsonArray.length();i++){
                productoVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productoVO.setIdProducto(jsonObject.optInt("id_producto"));
                productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
                productoVO.setDescripcionProducto(jsonObject.optString("descripcion_producto"));
                productoVO.setCategoriaProducto(jsonObject.optString("categoria_producto"));
                productoVO.setPresioProducto(jsonObject.optInt("presio_producto"));

                listaProductoVO.add(productoVO);
            }
            listaDatos = new ArrayList<>();
            for (int i=0; i<listaProductoVO.size();i++){
                if (listaProductoVO.get(i).getIdProducto() != 0) {
                    listaDatos.add(listaProductoVO.get(i).getIdProducto() + ". " + listaProductoVO.get(i).getNombreProducto());
                }
                else {
                    Toast.makeText(this, "Lista Vacia", Toast.LENGTH_SHORT).show();
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDatos);
            listView.setAdapter(arrayAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a C", Toast.LENGTH_SHORT).show();
            System.err.println("C....."+e.getCause()+"------"+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsultaCompleta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta C", Toast.LENGTH_SHORT).show();
        System.err.println("C....."+error);
    }

}