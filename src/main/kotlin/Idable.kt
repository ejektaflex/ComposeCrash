
abstract class Idable<T : Idable<T>> {

    abstract val reg: GameRegistry<T>

    open var id: String = "INVALID_ID"
        protected set

    @Suppress("UNCHECKED_CAST")
    private fun selfRegister() {
        id = reg.addEntry(this as T)
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun <T : Idable<T>> create(func: () -> Idable<T>): T {
            val item = func()
            item.selfRegister()
            return item as T
        }
    }

}
