import java.io.File
object ArchivoUtil {
    // Función para guardar el inventario en un archivo de texto
    fun guardarInventarioEnArchivo(inventario: Inventario, nombreArchivo: String) {
        val file = File(nombreArchivo)
        try {
            file.printWriter().use { writer ->
                for (producto in inventario.getProductos()) {
                    writer.println("${producto.nombre},${producto.precio},${producto.cantidadDisponible}")
                }
            }
            println("Inventario guardado exitosamente en el archivo: $nombreArchivo")
        } catch (e: Exception) {
            println("Error al guardar el inventario en el archivo.")
            e.printStackTrace()
        }
    }
    // Función para cargar el inventario desde un archivo de texto
    fun cargarInventarioDesdeArchivo(nombreArchivo: String): Inventario {
        val inventario = Menu.inventario
        val file = File(nombreArchivo)
        try {
            file.bufferedReader().use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    val parts = line!!.split(",")
                    val nombre = parts[0]
                    val precio = parts[1].toDouble()
                    val cantidad = parts[2].toInt()
                    val producto = Producto(nombre, precio, cantidad)
                    inventario.agregarProducto(producto)
                }
            }
            println("Inventario cargado exitosamente desde el archivo: $nombreArchivo")
        } catch (e: Exception) {
            println("Error al cargar el inventario desde el archivo.")
            e.printStackTrace()
        }
        return inventario
    }
}
