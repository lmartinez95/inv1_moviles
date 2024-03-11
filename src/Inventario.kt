class Inventario {
    private val productos: MutableList<Producto> = mutableListOf()
    // Función para agregar un producto al inventario
    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }
    // Función para eliminar un producto del inventario
    fun eliminarProducto(producto: Producto) {
        productos.remove(producto)
    }
    // Función para buscar un producto por su nombre en el inventario
    fun buscarProducto(nombre: String): Producto? {
        return productos.find { it.nombre == nombre }
    }
    // Función para mostrar el inventario
    fun mostrarInventario() {
        if (productos.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            println("----- Inventario -----")
            for (producto in productos) {
                println("Nombre: ${producto.nombre}    |     Precio: ${producto.precio}    |    Cantidad Disponible: ${producto.cantidadDisponible}")
                println("----------------")
            }
        }
    }

    fun getProductos(): MutableList<Producto>{
        return productos.toMutableList()
    }
}