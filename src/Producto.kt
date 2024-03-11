
class Producto(
    val nombre: String,
    val precio: Double,
    var cantidadDisponible: Int
) {
    // Función para actualizar la cantidad disponible del producto
    fun actualizarCantidad(nuevaCantidad: Int) {
        cantidadDisponible = nuevaCantidad
    }
    // Función para calcular el valor total del producto en base a su cantidad y precio
    fun calcularValorTotal(): Double {
        return precio * cantidadDisponible
    }
}