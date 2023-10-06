import java.util.Date;
import java.util.ArrayList;
//-------------Import todos-----------------//

public class Tarjeta extends Pago {
    private String tipo;
    private String numTransaccion;

    //----------------------Get 'n Set -> Basic ----------------------------------

    public Tarjeta(float monto, Date fecha, String tipo, String numTransaccion) {
        super (monto, fecha);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(String numTransaccion) {
        this.numTransaccion = numTransaccion;
    }
}