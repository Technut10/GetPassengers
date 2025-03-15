package example.getpassengers



open class Passenger(var fName:String,var lName:String, var phone:String) {
    
     var fullName:String=""
        get(){
            println("Getter called to return full name")
            return "$fName $lName"
            
        }
    init{
        println("<<< New Passenger Created!!")
        var fn:String = this.fullName
        val ID:Int=count++
    }

    override fun toString(): String {
        val fullName = "<<" + this.fName+""+ this.lName+""+this.phone+">>\n"
        
        return fullName
    }
    companion object{
        private var count:Int = 0
    }
}