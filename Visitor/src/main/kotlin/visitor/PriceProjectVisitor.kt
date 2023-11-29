package visitor

//* Clase que implementa la interfaz IVisitor para calcular el precio total de un proyecto.
// * El cálculo se realiza visitando actividades y acumulando los precios correspondientes
class PriceProjectVisitor : IVisitor<Number?> {
    private var totalPrice = 0.0
    // * Método de visita para un objeto Project.
//     * Recorre todas las actividades del proyecto y llama al método accept de cada una.
    override fun project(project: Project) {
        project.getActivities()!!.forEach{ it.accept(this)}
    }
// * Método de visita para un objeto Activity.
//     * Acumula el precio de la actividad en el totalPrice y visita las actividades asociadas.
    override fun activity(activity: Activity) {
        totalPrice += activity.getPrice()
        activity.getActivities().forEach{it.accept(this)}
    }
//* Método de visita para un objeto Employee.
//     * Este método está marcado con TODO porque no está implementado en la clase original.
//     * Si este método es necesario para el cálculo, debe implementarse según los requisitos del proyecto.
    override fun employee(employee: Employee) {
        TODO("Not yet implemented")
    }

//Método que devuelve el precio total acumulado durante la visita.
    override fun getResult(): Number {
        return totalPrice
    }
}