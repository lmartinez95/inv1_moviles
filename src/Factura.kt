class Factura {
    private val factura: MutableList<Carrito> = mutableListOf()
    private val inventario = Inventario()

    fun agregarFactura(carrito: Carrito) {
        factura.add(carrito)
    }
    // Función para eliminar un producto de la cuenta
    fun eliminarFactura(carrito: Carrito) {
        factura.remove(carrito)
    }

    // Función para buscar un producto por su nombre en la factura
    fun buscarItem(nombre: String): Carrito? {
        return factura.find { it.producto == nombre }
    }

    // Función para mostrar la pre-cuenta
    fun mostrarFactura() {
        if (factura.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            println("----- Pre-Cuenta -----")
            var total:Double = 0.0
            for (item in factura) {
                var prod = inventario.buscarProducto(item.producto)
                println("Nombre: ${item.producto}    |     Precio: ${prod!!.precio.toDouble()}    |    Cantidad: ${item.cantidad}")
                total += item.cantidad * prod.precio
                println("----------------")
            }
            println("TOTAL: ${total.toString()}")
        }
    }
}