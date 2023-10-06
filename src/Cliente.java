import java.util.Date;
import java.util.ArrayList;
//-------------Import todos-----------------//

public class Cliente {
    private String nombre;
    private String rut;

    public Cliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }
//-------------------------Get 'n Set----------------------------------//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
}
