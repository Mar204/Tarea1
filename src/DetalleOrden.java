import java.util.Date;
import java.util.ArrayList;
//-------------Import todos-----------------//

public class DetalleOrden {
    private int cantidad;
    private Articulo articulo;
    public DetalleOrden(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }
//-----------------------------Get 'n Set--------------------------------
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
//----------------------------FuncionesiMPORTANTES---------------------------------
    public float calcPrecio() {
        return 1.19f * cantidad * articulo.getPrecio();
    }
    public float calcPrecioSinIVA() {
        return cantidad * articulo.getPrecio();
    }
    public float calcIVA() {
        return 0.19f * cantidad* articulo.getPrecio();
    }
    public float calcPeso() {
        return cantidad * articulo.getPeso();
    }
}