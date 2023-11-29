package visitor


import jakarta.xml.bind.annotation.*


 //Clase que representa una actividad.
 // Implementa la interfaz IVisitable para permitir la visita de esta actividad por parte de un Visitor.

 // name Nombre de la actividad.
// price Precio de la actividad.
//responsible Empleado responsable de la actividad.
//activities Lista de actividades relacionadas con esta actividad.

@XmlRootElement(name = "Activitie")
@XmlAccessorType(XmlAccessType.FIELD)
class Activity: IVisitable {
    @XmlAttribute(name = "name")
    private var name: String? = null

    @XmlAttribute(name = "price")
    private var price = 0.0

    @XmlElement(name = "responsible")
    private var responsible: Employee? = null

    @XmlElement(name = "Activities")
    private var activities: MutableList<Activity>? = null

    constructor()

     //Constructor que inicializa una actividad con nombre, precio y empleado responsable.

      //name Nombre de la actividad.
      //price Precio de la actividad.
      //responsible Empleado responsable de la actividad.

    constructor(name: String?, price: Double, responsible: Employee?) {
        this.name = name
        this.price = price
        this.responsible = responsible
    }
    /**
     * Obtiene la lista de actividades relacionadas con esta actividad.
     * Si la lista es nula, se inicializa como un ArrayList antes de devolverla.
     *
     * @return Lista de actividades.
     */
    fun getActivities(): List<Activity> {
        if (activities == null) {
            activities = ArrayList()
        }
        return activities!!
    }
    /**
     * Establece la lista de actividades relacionadas con esta actividad.
     *
     * @param activities Nueva lista de actividades.
     */
    fun setActivities(activities: MutableList<Activity>?) {
        this.activities = activities
    }

    fun addActivity(activity: Activity) {
        if (activities == null) {
            activities = ArrayList()
        }
        this.activities!!.add(activity)
    }

    fun removeActivity(activity: Activity) {
        if (activities == null) {
            activities = ArrayList()
        }
        activities!!.remove(activity)
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.activity(this)
    }

    fun getPrice() = this.price
    fun setPrice (price: Double) {this.price =  price}

    fun getResponsible() = this.responsible
}
