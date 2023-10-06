import java.util.Date;
import java.util.List;
import java.util.ArrayList;
//------------------------------//

public class OrdenCompra {
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private Direccion direccionEnvio;
    private List<DetalleOrden> detalles;
    private DocTributario docTributario;
    private List<Pago> pagos;
    //Extra//
    private float montoFaltante;

//---------------------------Get 'n set -> Basic-----------------------------------------//

    public OrdenCompra(Date fecha, String estado, Cliente cliente, Direccion direccionEnvio) {
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
        this.detalles = new ArrayList <>();
        this.pagos = new ArrayList<>();
        //-------------------Extra------------------------
        this.montoFaltante = 0;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }

    public DocTributario getDocTributario() {
        return docTributario;
    }

    public void setDocTributario(DocTributario docTributario) {
        this.docTributario = docTributario;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    //--------------------------------------------------------------

    public void agregarDetalle(DetalleOrden detalle) {
        detalles.add(detalle);
        montoFaltante += detalle.calcPrecio();
    }
    //--------------------------------------------------------------

    public float calcPrecioSinIVA() {
        float precioSinIVA = 0;
        for (DetalleOrden detalle : detalles) {
            precioSinIVA += detalle.calcPrecioSinIVA();
        }
        return precioSinIVA;
    }

    public float calcIVA() {
        float iva = 0;
        for (DetalleOrden detalle : detalles) {
            iva += detalle.calcIVA();
        }
        return iva;
    }

    public float calcPrecio() {
        float precioTotal = 0;
        for (DetalleOrden detalle : detalles) {
            precioTotal += detalle.calcPrecio();
        }
        return precioTotal;
    }
    public void registrarPago(Pago pago) {
        pagos.add(pago);
        float montoTotalPagado = calcularMontoTotalPagado();
        this.montoFaltante = calcPrecio() - montoTotalPagado;
        if (montoFaltante <= 0) {
            this.estado = "Pagado";
        }
    }
    public float getMontoFaltante(){
        return montoFaltante;
    }

    public float calcPeso() {
        float pesoTotal = 0;
        for (DetalleOrden detalle : detalles) {
            pesoTotal += detalle.calcPeso();
        }
        return pesoTotal;
    }

    //----------------------------EXTRA------------------------------
    public float calcularMontoTotalPagado() {
        float montoTotal = 0.0f;
        for (Pago pago : pagos) {
            montoTotal += pago.getMonto();
        }
        return montoTotal;
    }
}

