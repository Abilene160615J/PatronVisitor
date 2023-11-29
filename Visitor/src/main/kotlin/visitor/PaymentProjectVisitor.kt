package visitor

//Clase que implementa la interfaz IVisitor para calcular los pagos acumulativos asociados a empleados en un proyecto.
// El cálculo se realiza visitando actividades y empleados y acumulando los pagos correspondientes.
class PaymentProjectVisitor : IVisitor<List<EmployeePay>> {
    // Mapa mutable para almacenar pagos acumulativos asociados a empleados.
    private val employeePayment: MutableMap<String?, Number> = HashMap()

   //Método de visita para un objeto Project.
     // Recorre todas las actividades del proyecto y llama al método accept de cada una.

    override fun project(project: Project) {
        project.getActivities()!!.forEach{it.accept(this)}
    }
//* Método de visita para un objeto Activity.
//     * Recorre todas las actividades y empleados asociados a la actividad actual y acumula los pagos.
    override fun activity(activity: Activity) {
        activity.getResponsible()!!.accept(this )
        activity.getActivities().forEach{it.accept(this)}
    }
//  Método de visita para un objeto Employee.
//     * Acumula el pago asociado al empleado en el mapa employeePayment.
    override fun employee(employee: Employee) {
        val resp = employee.name
        if (employeePayment.containsKey(resp)) {
            employeePayment[resp] = (
                    employeePayment[resp]!!.toDouble()
                            + employee.price)
        } else {
            employeePayment[resp] = employee.price
        }
    }
    //Método que devuelve una lista de objetos EmployeePay con los pagos acumulativos asociados a empleados.
    //     devuelve Lista de objetos EmployeePay.

    override fun getResult(): List<EmployeePay> {
        val response: MutableList<EmployeePay> = ArrayList<EmployeePay>()
        val keys: Set<String?> = employeePayment.keys
        for (key in keys) {
            response.add(
                EmployeePay( key,
                    employeePayment[key]!!.toDouble()
                )
            )
        }
        return response
    }
}

