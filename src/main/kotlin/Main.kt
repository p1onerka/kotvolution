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
import kotlinx.coroutines.runBlocking

import model.*
import model.parallel.convoluteAsyncPixel
import model.parallel.convoluteAsyncX
import model.parallel.convoluteAsyncY
import model.sequential.convolute
import org.bytedeco.opencv.global.opencv_imgcodecs
import org.bytedeco.opencv.global.opencv_imgproc
import org.bytedeco.opencv.opencv_core.Mat
import view.mainScreen
import viewModel.MainViewModel
import java.awt.Dimension

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main(args: Array<String>) = application {
    /*Window(onCloseRequest = ::exitApplication) {
        App()
    }*/
    val viewModel = MainViewModel()
    Window(
        onCloseRequest = ::exitApplication,
        title = "\uD83D\uDC08\u200D⬛Kotvolution\uD83D\uDC08\u200D⬛"
    ) {
        window.minimumSize = Dimension(1050, 750)
        mainScreen(viewModel)
    }
    /*val image = opencv_imgcodecs.imread("src/main/resources/night.jpeg")
    //val grayScale = Mat()
    opencv_imgproc.cvtColor(image, image, opencv_imgproc.COLOR_BGR2GRAY)
    val res = convoluteAsyncPixel(image, id, factorId, biasId)
    downloadPic("src/main/resources/night_out.jpeg", res)*/
}
