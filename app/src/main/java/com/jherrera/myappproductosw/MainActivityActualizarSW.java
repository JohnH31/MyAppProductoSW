package com.jherrera.myappproductosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappproductosw.complementos.MetodosSW;
import com.jherrera.myappproductosw.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText editTextBuscar,editTextNombre,editTextDescripcion,editTextCategoria,editTextPresio;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar_sw);
        editTextBuscar = findViewById(R.id.edtBuscarActualizarProducto);
        editTextNombre = findViewById(R.id.edtNombreProductoActualizar);
        editTextDescripcion = findViewById(R.id.edtDescripcionProductoActualizar);
        editTextCategoria = findViewById(R.id.edtCategoriaProductoActualizar);
        editTextPresio = findViewById(R.id.edtPresioProductoActualizar);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnActualizarProducto:
                this.actualizar();
                break;
            case R.id.imgBuscarA:
                this.buscarID();
                break;
        }
    }

    public void actualizar(){
        if (!editTextBuscar.getText().toString().isEmpty()&&!editTextNombre.getText().toString().isEmpty()&&
                !editTextDescripcion.getText().toString().isEmpty()&&!editTextCategoria.getText().toString().isEmpty()&&
                !editTextPresio.getText().toString().isEmpty()){
            metodosSW.actualizarSW(this,Integer.parseInt(editTextBuscar.getText().toString()),
                    editTextNombre.getText().toString(),editTextDescripcion.getText().toString(),
                    editTextCategoria.getText().toString(),Integer.parseInt(editTextPresio.getText().toString()),this,this);

            editTextBuscar.setText("");
            editTextNombre.setText("...");
            editTextDescripcion.setText("...");
            editTextCategoria.setText("...");
            editTextPresio.setText("...");
            Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    private void buscarID(){
        if (!editTextBuscar.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this,Integer.parseInt(editTextBuscar.getText().toString()),this,this);
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
                editTextNombre.setText(productoVO.getNombreProducto());
                editTextDescripcion.setText(productoVO.getDescripcionProducto());
                editTextCategoria.setText(productoVO.getCategoriaProducto());
                editTextPresio.setText(String.valueOf(productoVO.getPresioProducto()));
            }
            else{
                editTextNombre.setText("...");
                editTextDescripcion.setText("...");
                editTextCategoria.setText("...");
                editTextPresio.setText("...");
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
        Toast.makeText(this, "Error respuesta a A"+error, Toast.LENGTH_SHORT).show();
        System.err.println("A....."+error);
    }

}