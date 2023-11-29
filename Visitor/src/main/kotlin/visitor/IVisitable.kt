package visitor

//Interfaz que define el comportamiento de un objeto que puede ser visitado por un Visitor.
interface IVisitable {
    // Método de aceptación que permite que un Visitor realice operaciones específicas en el objeto que implementa esta interfaz.
    fun accept( visitor: IVisitor<*>)
}