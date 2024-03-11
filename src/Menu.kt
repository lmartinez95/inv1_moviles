
import java.util.Scanner
object Menu {
    private val scanner = Scanner(System.`in`)
    public val inventario = Inventario()
    public val factura = Factura()

    // Función para mostrar las opciones del menú
    private fun mostrarOpciones() {
        println("----- Menú -----")
        println("1. Seleccionar producto")
        println("2. Mostrar Pre-Cuenta")
        println("3. Remover item")
        println("4. Facturar")
        println("5. Salir")
        println("----------------")
    }
    // Función para ejecutar el menú
    fun ejecutarMenu() {
        var opcion: Int
        do {
            mostrarOpciones()
            print("Ingrese una opción: ")
            opcion = scanner.nextInt()
            when (opcion) {
                1 -> { mostrarInventario()
                    agregarProducto() }
                2 -> mostrarFactura()
                3 -> {
                    mostrarFactura()
                    removerItem()
                }
                4 -> cargarInventario()
                5 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Por favor, ingrese una opción válida.")
            }
        } while (opcion != 5)
    }
    // Función para agregar un producto al inventario
    private fun agregarProducto() {
        println("----- Agregar item -----")
        print("Ingrese el nombre del producto: ")
        val nombre = scanner.next()
        //var prod = inventario.buscarProducto(nombre)
        print("Ingrese la cantidad: ")
        val cantidad = scanner.nextInt()
        var carrito = Carrito(nombre, cantidad)
        factura.agregarFactura(carrito)
        println("Producto agregado con éxito.")
        println("----------------")
    }
    private fun removerItem(){
        mostrarInventario()
        print("Ingrese el nombre del producto a eliminar: ")
        val nombre = scanner.next()
        var prod = factura.buscarItem(nombre)
        var item = Carrito(nombre, prod!!.cantidad.toInt())
        factura.eliminarFactura(item)
    }
    private fun mostrarFactura(){
        factura.mostrarFactura()
    }







    // Función para mostrar el inventario
    private fun mostrarInventario() {
        inventario.mostrarInventario()
    }
    // Función para guardar el inventario en un archivo
    private fun guardarInventario() {
        print("Ingrese el nombre del archivo para guardar el inventario: ")
        val nombreArchivo = scanner.next()
        ArchivoUtil.guardarInventarioEnArchivo(inventario, nombreArchivo)
    }
    // Función para cargar el inventario desde un archivo
    fun cargarInventario() {
        //print("Ingrese el nombre del archivo para cargar el inventario: ")
        val nombreArchivo = "carrito.txt"//scanner.next()

        val nuevoInventario = ArchivoUtil.cargarInventarioDesdeArchivo(nombreArchivo)
        inventario.getProductos().clear()
        inventario.getProductos().addAll(nuevoInventario.getProductos())
    }
}