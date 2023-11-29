package visitor


import jakarta.xml.bind.JAXBContext


fun main() {
    var project: Project? = null
    try {
        val context = JAXBContext.newInstance(Project::class.java)

        val unmarshaller = context.createUnmarshaller()
        project = unmarshaller
            .unmarshal(
                object {}.javaClass
                    .getResourceAsStream("Project.xml")
            ) as Project?

    } catch (e: Exception) {
        println(e.message)
        e.printStackTrace()
    }
    //Obtener el costo total del proyecto
    val costVisitor = CostProjectVisitor()
    project!!.accept(costVisitor )
    val cost = costVisitor.getResult().toDouble()
    println("Costo total > $cost")
    val priceVisitor = PriceProjectVisitor()
    project.accept(priceVisitor)
    val price = priceVisitor.getResult().toDouble()
    println("Precio total > $price")
    println("Ganancia Total > " + (price - cost))
    println("\n:::::::: Pagar a los trabajadores :::::::")
    val paymentVisitor = PaymentProjectVisitor()
    project.accept(paymentVisitor)
    val result = paymentVisitor.getResult()
    for ((employeeName, totalPay) in result) {
        println(
            employeeName
                    + " > " + totalPay
        )
    }
}