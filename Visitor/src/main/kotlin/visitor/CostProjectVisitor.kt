package visitor

/**
 * Clase que implementa la interfaz IVisitor para calcular el costo total de un proyecto.
 * El costo se calcula sumando los precios de los empleados asociados a las actividades del proyecto.
 *
 * @property totalCost Costo total acumulado durante la visita.
 */
class CostProjectVisitor : IVisitor<Number> {
    private var totalCost = 0.0

    /**
     * Método de visita para un objeto Project.
     * Recorre todas las actividades del proyecto y llama al método accept de cada una.
     *
     * @param project Proyecto a visitar.
     */
    override fun project(project: Project) {
        project.getActivities()!!.forEach { it.accept(this) }
    }

    /**
     * Método de visita para un objeto Activity.
     * Recorre todas las actividades y empleados asociados a la actividad actual y acumula los costos.
     *
     * @param activity Actividad a visitar.
     */
    override fun activity(activity: Activity) {
        // Visita al empleado responsable de la actividad
        activity.getResponsible()!!.accept(this)

        // Visita a las actividades asociadas a la actividad actual
        activity.getActivities().forEach { it.accept(this) }
    }

    /**
     * Método de visita para un objeto Employee.
     * Acumula el precio del empleado en el costo total.
     *
     * @param employee Empleado a visitar.
     */
    override fun employee(employee: Employee) {
        totalCost += employee.price
    }

    /**
     * Obtiene el resultado final del cálculo del costo total.
     *
     * @return Costo total acumulado durante la visita.
     */
    override fun getResult(): Number {
        return totalCost
    }
}