import java.util.Date;
import java.util.ArrayList;
//-------------Import todos-----------------//

public class Efectivo extends Pago {
    // Constructor
    public Efectivo(float monto, Date fecha) {
        super(monto, fecha);
    }
    public float calcDevolucion(float montoCompra, OrdenCompra ordenCompra) {
        float montoPagadoEnEfectivo = 0.0f;
        for (Pago pago : ordenCompra.getPagos()) {
            if (pago instanceof Efectivo) {
                montoPagadoEnEfectivo += pago.getMonto();
            }
        }
        float devolucion = montoPagadoEnEfectivo - montoCompra;
        return Math.max(0.0f, devolucion);
    }
}