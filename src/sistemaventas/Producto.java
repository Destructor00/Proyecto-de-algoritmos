package sistemaventas;

import java.util.Scanner;

public class Producto {

    public static void Ventas() {
        Scanner teclado = new Scanner(System.in);

        int op;
        int confirmar = 2;
        int numProduc;
        int i;
        double subtotal = 0;
        int codigo;
        int cantidad;
        double precio;
        String nombre;
        double descuento;
        double montoConDescuento;
        double IVA;
        double total;
        int metodo;
        String formaPago = "";
        double recibido = 0;
        double cambio = 0;
        int ventasRealizadas = 0;
        int productosVendidos = 0;
        double totalVendido = 0;
        int ventasEfectivo = 0;
        int ventasTarjeta = 0;
        int ventasTransferencia = 0;
        double ventaMayor = 0;
        double ventaMenor = 0;
        int cantidadVenta = 0;

        do {
            System.out.println("\n+==============================+");
            System.out.println("|        SISTEMA DE VENTAS     |");
            System.out.println("|==============================|");
            System.out.println("|  1. Registrar una venta      |");
            System.out.println("|  2. Consultar caja           |");
            System.out.println("|  3. Mostrar estadisticas     |");
            System.out.println("|  4. Salir                    |");
            System.out.println("+==============================+");
            System.out.print("Opcion: ");
            op = teclado.nextInt();

            switch (op) {
                case 1:

                    System.out.println("Cuantos productos tendra la venta?");
                    numProduc = teclado.nextInt();

                    while (numProduc <= 0) {
                        System.out.println("Debe ser mayor que cero.");
                        System.out.print("Cuantos productos tendra la venta? ");
                        numProduc = teclado.nextInt();
                    }
                    cantidadVenta = 0;
                    subtotal = 0;
                    for (i = 1; i <= numProduc; i++) {
                        System.out.println("\nProducto " + i);
                        System.out.print("Codigo: ");
                        codigo = teclado.nextInt();

                        System.out.print("Nombre: ");
                        nombre = teclado.next();

                        System.out.print("Precio: ");
                        precio = teclado.nextDouble();
                        while (precio <= 0) {
                            System.out.println("El precio debe ser mayor que cero.");
                            System.out.print("Precio: ");
                            precio = teclado.nextDouble();
                        }

                        System.out.print("Cantidad: ");
                        cantidad = teclado.nextInt();
                        while (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor que cero.");
                            System.out.print("Cantidad: ");
                            cantidad = teclado.nextInt();
                        }
                        subtotal = subtotal + precio * cantidad;
                        cantidadVenta = cantidadVenta + cantidad;

                    }

                    if (subtotal >= 1000) {
                        descuento = subtotal * 0.10;
                    } else if (subtotal >= 500) {
                        descuento = subtotal * 0.08;
                    } else if (subtotal >= 200) {
                        descuento = subtotal * 0.05;
                    } else {
                        descuento = 0;
                    }
                    montoConDescuento = subtotal - descuento;
                    IVA = montoConDescuento * 0.12;
                    total = montoConDescuento + IVA;

                    System.out.println("Subtotal: Q" + subtotal);
                    System.out.println("Descuento: Q" + descuento);
                    System.out.println("Monto con descuento: Q" + montoConDescuento);
                    System.out.println("IVA: Q" + IVA);
                    System.out.println("Total: Q" + total);

                    System.out.println("\nForma de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Transferencia");
                    System.out.print("Metodo: ");
                    metodo = teclado.nextInt();

                    while (metodo < 1 || metodo > 3) {
                        System.out.println("Opcion invalida.");
                        System.out.print("Metodo: ");
                        metodo = teclado.nextInt();
                    }

                    switch (metodo) {
                        case 1:
                            formaPago = "Efectivo";
                            ventasEfectivo = ventasEfectivo + 1;
                            System.out.print("Monto recibido: ");
                            recibido = teclado.nextDouble();
                            while (recibido < total) {
                                System.out.println("Efectivo insuficiente.");
                                System.out.print("Monto recibido: ");
                                recibido = teclado.nextDouble();
                            }
                            cambio = recibido - total;

                            break;
                        case 2:
                            formaPago = "Tarjeta";
                            ventasTarjeta = ventasTarjeta + 1;
                            break;
                        case 3:
                            formaPago = "Transferencia";
                            ventasTransferencia = ventasTransferencia + 1;
                            break;
                    }
                    System.out.println("\n==== RESUMEN DE LA VENTA ====");
                    System.out.println("Cantidad de productos: " + cantidadVenta);
                    System.out.println("Subtotal: Q" + subtotal);
                    System.out.println("Descuento: Q" + descuento);
                    System.out.println("IVA: Q" + IVA);
                    System.out.printf("Total: Q%.2f%n", total); // es para que solo hayan dos decimales
                    System.out.println("Forma de pago: " + formaPago);
                    if (metodo == 1) {
                        System.out.println("Efectivo recibido: Q" + recibido);
                        System.out.println("Cambio: Q" + cambio);
                    }
                    ventasRealizadas = ventasRealizadas + 1;
                    productosVendidos = productosVendidos + cantidadVenta;
                    totalVendido = totalVendido + total;

                    if (ventasRealizadas == 1) {
                        ventaMayor = total;
                        ventaMenor = total;
                    } else {
                        if (total > ventaMayor) {
                            ventaMayor = total;
                        }
                        if (total < ventaMenor) {
                            ventaMenor = total;

                        }

                    }
                    break;

                case 2:
                    System.out.println("\n====== CAJA ======");
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("Productos vendidos: " + productosVendidos);
                    System.out.println("Total vendido Q: " + totalVendido);
                    System.out.println("Ventas por efectivo: " + ventasEfectivo);
                    System.out.println("Ventas por tarjeta: " + ventasTarjeta);
                    System.out.println("Ventas por transferencia: " + ventasTransferencia);
                    System.out.println("  ==================");

                    break;

                case 3:
                    if (ventasRealizadas == 0) {
                        System.out.println("No existen ventas registradas.");
                    } else {
                        System.out.println("\n====== ESTADISTICAS ======");
                        System.out.println("Total de ventas: " + ventasRealizadas);
                        System.out.println("Productos vendidos: " + productosVendidos);
                        System.out.println("Total vendido: Q" + totalVendido);
                        System.out.println("Promedio por venta: Q" + (totalVendido / ventasRealizadas));
                        System.out.println("Ventas en efectivo: " + ventasEfectivo);
                        System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                        System.out.println("Ventas por transferencia: " + ventasTransferencia);
                        System.out.println("Venta mayor: Q" + ventaMayor);
                        System.out.println("Venta menor: Q" + ventaMenor);
                        System.out.println("  ==========================");
                    }
                    break;
                case 4:
                    System.out.println("Seguro que desea salir? (1 = Si, 2 = No)");
                    confirmar = teclado.nextInt();

                    while (confirmar != 1 && confirmar != 2) {
                        System.out.println("Opcion invalida.");
                        System.out.println("Seguro que desea salir? (1 = Si, 2 = No)");
                        confirmar = teclado.nextInt();
                    }

                    if (confirmar == 1) {
                        System.out.println("Saliendo...");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (confirmar != 1);
    }
}
