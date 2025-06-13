package viewModel

import kotlinx.coroutines.runBlocking
import model.BIAS_BLUR
import model.BIAS_HOR_EDGES
import model.BIAS_ID
import model.BIAS_MOTION
import model.BIAS_SHARPEN
import model.BIAS_VER_EDGES
import model.BLUR
import model.FACTOR_BLUR
import model.FACTOR_HOR_EDGES
import model.FACTOR_ID
import model.FACTOR_MOTION
import model.FACTOR_SHARPEN
import model.FACTOR_VER_EDGES
import model.HOR_EDGES
import model.ID
import model.MOTION
import model.SHARPEN
import model.VER_EDGES
import model.downloadPic
import model.parallel.convolveFrame
import model.parallel.convolvePixel
import model.parallel.convolveX
import model.parallel.convolveY
import model.sequential.convolve
import model.uploadPic

class MainScreenViewModel {
    // private var imageLoaded by mutableStateOf(false)

    /*fun loadImage(path: String) {
        imageLoaded = true
    }*/
    fun chooseFilter(filter: String): Triple<Array<DoubleArray>, Double, Double> {
        return when (filter) {
            "Blur" -> Triple(BLUR, FACTOR_BLUR, BIAS_BLUR)
            "ID" -> Triple(ID, FACTOR_ID, BIAS_ID)
            "Horizontal_edges" -> Triple(HOR_EDGES, FACTOR_HOR_EDGES, BIAS_HOR_EDGES)
            "Vertical_edges" -> Triple(VER_EDGES, FACTOR_VER_EDGES, BIAS_VER_EDGES)
            "Sharpen" -> Triple(SHARPEN, FACTOR_SHARPEN, BIAS_SHARPEN)
            else -> Triple(MOTION, FACTOR_MOTION, BIAS_MOTION)
        }
    }

    fun applyFilter(
        filter: String,
        method: String,
        path: String,
        frameW: Int,
        frameH: Int,
    ): String =
        runBlocking {
            val input = uploadPic(path)
            val (matrix, factor, bias) = chooseFilter(filter)
            val result =
                when (method) {
                    "Sequential" -> convolve(input, matrix, factor, bias)
                    "Parallel pixel-wise" -> convolvePixel(input, matrix, factor, bias)
                    "Parallel row-wise" -> convolveY(input, matrix, factor, bias)
                    "Parallel column-wise" -> convolveX(input, matrix, factor, bias)
                    "Parallel via frames" -> convolveFrame(input, matrix, factor, bias, frameW, frameH)
                    else -> convolve(input, matrix, factor, bias)
                }

            val typeInd = path.lastIndexOf('.')
            val pathNoType = path.substring(0, typeInd)
            val pathType = path.substring(typeInd)
            val outPath = pathNoType + "_with$filter" + pathType
            downloadPic(outPath, result)
            return@runBlocking outPath
        }
}
