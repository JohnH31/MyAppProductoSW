package com.jherrera.myappproductosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappproductosw.complementos.MetodosSW;

import org.json.JSONObject;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editTextNombre,editTextDescripcion,editTextCategoria,editTextPresio;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);
        editTextNombre = findViewById(R.id.edtNombreProducto);
        editTextDescripcion = findViewById(R.id.edtDescripcionProducto);
        editTextCategoria = findViewById(R.id.edtCategoriaProducto);
        editTextPresio = findViewById(R.id.edtPresioProducto);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertarProducto:
                this.insertar();
                break;
        }
    }
    private void insertar(){
        if (!editTextNombre.getText().toString().isEmpty()&&!editTextDescripcion.getText().toString().isEmpty()&&
                !editTextCategoria.getText().toString().isEmpty()&&!editTextPresio.getText().toString().isEmpty()){

            metodosSW.insertarSW(this,editTextNombre.getText().toString(),editTextDescripcion.getText().toString(),
                    editTextCategoria.getText().toString(),Integer.parseInt(editTextPresio.getText().toString()),
                    this,this);

            editTextNombre.setText("");
            editTextDescripcion.setText("");
            editTextCategoria.setText("");
            editTextPresio.setText("");
        }else {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente"+error, Toast.LENGTH_SHORT).show();
        System.err.println("I....."+error);
    }

}