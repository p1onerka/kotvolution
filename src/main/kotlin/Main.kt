/* there will be GUI if I'm not too lazy */

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import model.*
//import model.sequential.convolve
import org.bytedeco.opencv.global.opencv_imgcodecs
import view.mainScreen
import viewModel.MainViewModel
import java.awt.Dimension
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.time.DurationUnit
import kotlin.time.measureTime

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

fun main(args: Array<String>) = application {
    val viewModel = MainViewModel()
    Window(
        onCloseRequest = ::exitApplication,
        title = "\uD83D\uDC08\u200D⬛Kotvolution\uD83D\uDC08\u200D⬛"
    ) {
        window.minimumSize = Dimension(1050, 750)
        mainScreen(viewModel)
    }
}
