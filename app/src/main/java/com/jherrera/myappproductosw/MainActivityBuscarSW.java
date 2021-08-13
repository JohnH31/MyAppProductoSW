package com.jherrera.myappproductosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappproductosw.complementos.MetodosSW;
import com.jherrera.myappproductosw.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityBuscarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText;
    TextView textViewNombre,textViewDescripcion,textViewCategoria,textViewPresio;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar_sw);
        editText = findViewById(R.id.edtBuscarProducto);
        textViewNombre = findViewById(R.id.txtNombreProducto);
        textViewDescripcion = findViewById(R.id.txtDescripcionProducto);
        textViewCategoria = findViewById(R.id.txtCategoriaProducto);
        textViewPresio = findViewById(R.id.txtPresioProducto);

    }


    public void onClick(View view) {
        this.buscarID();
    }

    private void buscarID(){
        if (!editText.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this,Integer.parseInt(editText.getText().toString()),this,this);
        }else{
            Toast.makeText(this, "Debe de llenar el campo ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultadoConsulta(JSONObject response){
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
            productoVO.setDescripcionProducto(jsonObject.optString("descripcion_producto"));
            productoVO.setCategoriaProducto(jsonObject.optString("categoria_producto"));
            productoVO.setPresioProducto(jsonObject.optInt("presio_producto"));

            String dato = productoVO.getNombreProducto();
            if (!dato.equals("...")){
                textViewNombre.setText(productoVO.getNombreProducto());
                textViewDescripcion.setText(productoVO.getDescripcionProducto());
                textViewCategoria.setText(productoVO.getCategoriaProducto());
                textViewPresio.setText(String.valueOf(productoVO.getPresioProducto()));
            }
            else{
                textViewNombre.setText("...");
                textViewDescripcion.setText("...");
                textViewCategoria.setText("...");
                textViewPresio.setText("...");
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a A", Toast.LENGTH_SHORT).show();
            System.err.println("A....."+e.getCause()+"------"+e.getMessage());
        }
    }


    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        System.err.println("B....."+error);

    }

}