import kotlinx.serialization.Serializable

@Serializable
data class GameRegistry<T : Idable<T>>(
    var name: String,
    val regReg: Boolean = false,
    private val content: MutableMap<String, T> = mutableMapOf()
)
    : Idable<GameRegistry<*>>(), Map<String, T> by content {

    val ids: List<String>
        get() = this().map { it.id }

    override val reg: GameRegistry<GameRegistry<*>>
        get() = Registries.Registry

    // Auto incrementing key for new indices
    private var autoKey = 0
        get() {
            return field++
        }

    init {
        if (!regReg) {
            run {
                id = Registries.Registry.addEntry(this, "REGISTRY_" + name.toUpperCase())
            }
        }
    }

    operator fun invoke(): List<T> = content.values.toList()

    operator fun iterator() = content.iterator()


    fun clear() = content.clear()

    fun addEntry(entry: T, uid: String = name): String {
        val newUid = "$autoKey|${uid}"
        if (newUid in content) {
            throw Exception("Entry $entry is already in registry '$id'!")
        }
        content[newUid] = entry
        return newUid
    }

    override fun toString(): String {
        return "GameRegistry[$name]"
    }

}