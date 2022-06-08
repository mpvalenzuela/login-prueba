package cl.seccion121.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsr, etClave, etReiClave, etCorreo;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etUsr = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        etReiClave = findViewById(R.id.etReiClave);
        etCorreo = findViewById(R.id.etCorreo);

        btnRegistrar = findViewById(R.id.btnRegistrar);

    }

    public void clickBoton(View v){
        if (validacionOK())
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Tiene errores", Toast.LENGTH_SHORT).show();
    }

    private boolean validacionOK(){
        String usr, clave, reiClave, correo;

        usr = etUsr.getText().toString();
        usr = usr.replaceAll(" ", ""); //Sacar espacios de la variable
        //usr = usr.substring(0, 19);
        etUsr.setText(usr);//Cambiando el contenido del widget

        clave = etClave.getText().toString();
        reiClave = etReiClave.getText().toString();
        correo = etCorreo.getText().toString();

        if(usr.isEmpty())
            etUsr.setError(getString(R.string.obligatorio));

        if(clave.isEmpty())
            etClave.setError(getString(R.string.obligatorio));

        if(reiClave.isEmpty())
            etReiClave.setError(getString(R.string.obligatorio));

        if(correo.isEmpty())
            etCorreo.setError(getString(R.string.obligatorio));

        if(!clave.equals(reiClave))
            etReiClave.setError(getString(R.string.error_reingreso_clave));

        if(usr.isEmpty() || clave.isEmpty() || reiClave.isEmpty() || correo.isEmpty()
            || !clave.equals(reiClave))
            return false;

        Log.d("TAG_", usr);
        Log.d("TAG_", clave);
        Log.d("TAG_", reiClave);
        Log.d("TAG_", correo);

        return true;

    }
}