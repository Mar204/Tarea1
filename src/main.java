import java.util.Date;
import java.util.List;
import java.util.ArrayList;
//------------------------------//

public class main {
    public static void main(String[] args) {
        //-----------------------------Colocamos datos----------------------------------
        Cliente cliente = new Cliente("Juan Carlos Bodoque", "45867-4");
        Direccion direccion = new Direccion("Banco de titirilquen");
        Articulo articulo1 = new Articulo(0.5f, "Microfono", "Descripción del Producto A", 100.0f);
        Articulo articulo2 = new Articulo(0.3f, "Camara", "Descripción del Producto B", 100.0f);

        OrdenCompra ordenCompra = new OrdenCompra(new Date(), "En proceso", cliente, direccion);

        DetalleOrden detalle1 = new DetalleOrden(articulo1, 3);
        DetalleOrden detalle2 = new DetalleOrden(articulo2, 2);

        ordenCompra.agregarDetalle(detalle1);
        ordenCompra.agregarDetalle(detalle2);

        //--------------------------------Imprimimos------------------------------------
        System.out.println("\n---------------------->>Precios ' n Peso<<------------------------------\n");

        float precioTotal = ordenCompra.calcPrecio();
        float pesoTotal = ordenCompra.calcPeso();
        float montoFaltante = ordenCompra.getMontoFaltante();
        float preciosinIVA = ordenCompra.calcPrecioSinIVA();
        float ivauwu = ordenCompra.calcIVA();
        System.out.println("Precio total de la orden con IVA: $" + precioTotal);
        System.out.println("Precio total de la orden sin IVA: $" + preciosinIVA);
        System.out.println("IVA: $" + ivauwu);
        System.out.println("Peso total de la orden:" + pesoTotal + "kg");
        System.out.println("Monto restante por pagar: $" + montoFaltante);
        System.out.println("\n------------------------>>Pago<<----------------------------\n");

        Efectivo pagoEfectivo = new Efectivo(50.0f, new Date());
        ordenCompra.registrarPago(pagoEfectivo);

        float montoTotalPagado = ordenCompra.calcularMontoTotalPagado();
        System.out.println("Monto total pagado: $" + montoTotalPagado);

        System.out.println("\n------------------------>>Informacion<<----------------------------\n");

        System.out.println("Detalles de la orden:");
        System.out.println("\n");
        for (DetalleOrden detalle : ordenCompra.getDetalles()) {
            System.out.println("Artículo: " + detalle.getArticulo().getNombre());
            System.out.println("Cantidad: " + detalle.getCantidad());
            System.out.println("Precio sin IVA: $" + detalle.calcPrecioSinIVA());
            System.out.println("Peso: " + detalle.calcPeso() + " kg");
            System.out.println("\n");
        }

        System.out.println("-------------------------->>Registro<<--------------------------\n");

        System.out.println("Pagos realizados:");
        for (Pago pago : ordenCompra.getPagos()) {
            System.out.println("Monto: $" + pago.getMonto());
            System.out.println("Fecha: " + pago.getFecha());
            System.out.println("\n");
        }
        System.out.println("-------------------------->>Perfil<<--------------------------\n");
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("RUT: " + cliente.getRut());

        System.out.println("\n-------------------------->>Orden<<--------------------------\n");

        System.out.println("Estado de la orden de compra del cliente:");
        System.out.println("Estado: " + ordenCompra.getEstado());

        System.out.println("\n-------------------------->>Deuda<<--------------------------\n");

        System.out.println("Monto que falta por pagar: $" + ordenCompra.getMontoFaltante());

        System.out.println("\n-------------------------->>SegundaCuota<<--------------------------\n");

        Efectivo pagoEfectivo2 = new Efectivo(600f, new Date());
        ordenCompra.registrarPago(pagoEfectivo2);

        float montoCompra = ordenCompra.calcPrecio();
        float devolucion = pagoEfectivo2.calcDevolucion(montoCompra, ordenCompra);
        float montoT = ordenCompra.calcularMontoTotalPagado();
        System.out.println("Precio total de la orden con IVA: $" + precioTotal);
        System.out.println("Total pagado:" + montoT);
        System.out.println("Devolución: $" + devolucion);
        System.out.println("\n-------------------------->>Registro<<--------------------------\n");
        System.out.println("Pagos realizados:");
        for (Pago pago : ordenCompra.getPagos()) {
            System.out.println("Tipo de pago: " + pago.getClass().getSimpleName());
            System.out.println("Monto: $" + pago.getMonto());
            System.out.println("Fecha: " + pago.getFecha());
            System.out.println("\n");
        }
        System.out.println("\n------------------------->>Orden<<---------------------------\n");

        System.out.println("Estado de la orden de compra del cliente:");
        System.out.println("Estado: " + ordenCompra.getEstado());

        System.out.println("\n----------------------------------------------------\n");
    }
}
