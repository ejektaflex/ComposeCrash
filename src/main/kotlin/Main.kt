import androidx.compose.desktop.Window
import androidx.compose.ui.unit.IntSize

object Registries {

    val Registry = GameRegistry<GameRegistry<*>>("master_registry")

}

fun main() = Window(title = "Falling Balls", size = IntSize(800, 800)) {
    // should crash
}