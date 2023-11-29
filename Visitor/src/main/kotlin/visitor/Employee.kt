package visitor

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlAttribute
import jakarta.xml.bind.annotation.XmlRootElement
import java.util.*


@XmlRootElement(name = "Responsible")
@XmlAccessorType(XmlAccessType.FIELD)
class Employee: IVisitable{
    @XmlAttribute(name = "name")
    var name: String

    @XmlAttribute(name = "price")
    var price: Double

    constructor(){}
    constructor(name: String, price: Double){
        this.name = name
        this.price = price
    }
     // Método de inicialización que establece valores predeterminados para el nombre y precio del empleado.
    init {
        this.name=""
        this.price=0.0
    }
    //Método de aceptación para permitir que un Visitor realice operaciones específicas en este empleado.
    override fun accept(visitor: IVisitor<*>) {
        visitor.employee(this)
    }
    //Método hashCode que genera un código hash basado en el nombre del empleado.
    override fun hashCode(): Int {
        var hash = 7
        hash = 37 * hash + Objects.hashCode(name)
        return hash
    }
//Método equals que compara la igualdad de dos objetos Employee basándose en el nombre.
    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val other = obj as Employee
        return name == other.name
    }
}
