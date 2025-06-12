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
import model.sequential.convolute
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
    /*val inputPath = if (args.isEmpty()) { "src/main/resources/night.jpeg" } else args[0]
    val input = uploadPic(inputPath)
    val testF = arrayOf(
    doubleArrayOf(0.0, 0.2, 0.0),
    doubleArrayOf(0.2, 0.2, 0.2),
    doubleArrayOf(0.0, 0.2, 0.0))
    val testF2 = arrayOf(
        doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0))
    val res = convolute(input, testF, 1.0, 0.0)
    val outputPath = if (args.size < 2) { "src/main/resources/night_out.jpeg" } else args[1]
    println("IM HERE")
    downloadPic(outputPath, res)*/
    val viewModel = MainViewModel()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Image Convolution App"
    ) {
        window.minimumSize = Dimension(1050, 750)
        mainScreen(viewModel)
    }
}
