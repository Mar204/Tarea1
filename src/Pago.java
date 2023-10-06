import java.util.Date;
import java.util.ArrayList;
//-------------Import todos-----------------//

public class Pago {
    private float monto;
    private Date fecha;

    //----------------- Set 'n Get -> Basic ----------------------
    public Pago(float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}