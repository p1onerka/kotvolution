package viewModel

import kotlinx.coroutines.runBlocking
import model.*
import model.parallel.convoluteAsyncFrame
import model.parallel.convoluteAsyncPixel
import model.parallel.convoluteAsyncX
import model.parallel.convoluteAsyncY
import model.sequential.convolute

class MainViewModel {
    //private var imageLoaded by mutableStateOf(false)

    /*fun loadImage(path: String) {
        imageLoaded = true
    }*/
    fun chooseFilter (filter: String): Triple<Array<DoubleArray>, Double, Double> {
        return when (filter) {
            "Blur" -> Triple(blur, factorBlur, biasBlur)
            "ID" -> Triple(id, factorId, biasId)
            "Horizontal_edges" -> Triple(horEdges, factorHorEdges, biasHorEdges)
            "Vertical_edges" -> Triple(verEdges, factorVerEdges, biasVerEdges)
            "Sharpen" -> Triple(sharpen, factorSharpen, biasSharpen)
            else -> Triple(motion, factorMotion, biasMotion)
        }
    }

    fun applyFilter(filter: String, method: String, path: String, frameW: Int, frameH: Int): String = runBlocking {
        val input = uploadPic(path)
        val (matrix, factor, bias) = chooseFilter(filter)
        val result = when (method) {
            "Sequential" -> convolute(input, matrix, factor, bias)
            "Parallel pixel-wise" -> convoluteAsyncPixel(input, matrix, factor, bias)
            "Parallel row-wise" -> convoluteAsyncY(input, matrix, factor, bias)
            "Parallel column-wise" -> convoluteAsyncX(input, matrix, factor, bias)
            "Parallel via frames" -> convoluteAsyncFrame(input, matrix, factor, bias, frameW, frameH)
            else -> convolute(input, matrix, factor, bias)
        }

        val typeInd = path.lastIndexOf('.')
        val pathNoType = path.substring(0, typeInd)
        val pathType = path.substring(typeInd)
        val outPath = pathNoType + "_with$filter" + pathType
        downloadPic(outPath, result)
        return@runBlocking outPath
    }
}
