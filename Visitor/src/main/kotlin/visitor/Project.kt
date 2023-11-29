package visitor

import jakarta.xml.bind.annotation.*

//* Clase que representa un proyecto.
 //* Implementa la interfaz IVisitable para permitir la visita de esta instancia por parte de un Visitor.
@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
class Project: IVisitable {
    // Nombre del proyecto.
    @XmlAttribute(name = "name")
    var name: String

    @XmlElement(name = "Activities")
    // Lista de actividades asociadas al proyecto.
    private var activities: MutableList<Activity>? = null

    init {
        this.name=""
    }
    constructor()
    //Constructor que inicializa el nombre del proyecto.
    constructor(name: String) {
        this.name = name
    }
//Obtiene la lista de actividades asociadas al proyecto.
//     * Si la lista es nula, se inicializa como un ArrayList antes de devolverla.
    fun getActivities(): List<Activity>? {
        if (activities == null) {
            activities = ArrayList<Activity>()
        }
        return activities
    }
//Establece la lista de actividades asociadas al proyecto
    fun setActivities(activities: MutableList<Activity>?) {
        this.activities = activities
    }
//* Agrega una actividad a la lista de actividades asociadas al proyecto.
//     * Si la lista es nula, se inicializa como un ArrayList antes de agregar la actividad.
    fun addActivity(activity: Activity) {
        if (activities == null) {
            activities = ArrayList<Activity>()
        }
        activities!!.add(activity)
    }
//Método de aceptación para permitir que un Visitor realice operaciones específicas en este proyecto.
    override fun accept(visitor: IVisitor<*>) {
        visitor.project(this)
    }


}

