package visitor


 //Interfaz que define un Visitor que puede realizar operaciones específicas en objetos de diferentes tipos.
 //Los métodos project, activity y employee representan las operaciones que el Visitor puede realizar en cada tipo de objeto.
 // getResult devuelve el resultado acumulado de las operaciones realizadas por el Visitor.

interface  IVisitor <out T> {
    fun project(project: Project)
    fun activity(activity: Activity)
    fun employee(employee: Employee)
    fun getResult(): T
}
