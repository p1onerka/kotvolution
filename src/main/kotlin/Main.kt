// there will be GUI if I'm not too lazy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import view.mainScreen
import viewModel.MainScreenViewModel
import java.awt.Dimension

// import model.sequential.convolve

/*fun experimentHelper (path: String) {
    val image = opencv_imgcodecs.imread(path)
    val list = mutableListOf<Double>()
    for (i in 0..20) {
        val timeTaken = measureTime {
            convolve(image, blur, 1.0, 0.0)
        }.toDouble(DurationUnit.MILLISECONDS)
        list.add(timeTaken)
    }
    val mean = list.average()
    val sd = sqrt(list.sumOf {(mean - it).pow(2)/19.0})
    val sem = sd/sqrt(19.0)
    println("time is $mean ms +- $sem ms")
}*/

fun main() =
    application {
        val viewModel = MainScreenViewModel()
        Window(
            onCloseRequest = ::exitApplication,
            title = "\uD83D\uDC08\u200D⬛Kotvolution\uD83D\uDC08\u200D⬛",
        ) {
            window.minimumSize = Dimension(1050, 750)
            mainScreen(viewModel)
        }
    }
