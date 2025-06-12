package viewModel


/*import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue*/
import model.*
import model.sequential.convolute

class MainViewModel {
    //private var imageLoaded by mutableStateOf(false)

    /*fun loadImage(path: String) {
        imageLoaded = true
    }*/

    fun applyFilter(filter: String, path: String): String {
        val input = uploadPic(path)
        val result = when (filter) {
            "Blur" -> convolute(input, blur, factorBlur, biasBlur)
            "ID" -> convolute(input, id, factorId, biasId)
            "Horizontal_edges" -> convolute(input, horEdges, factorHorEdges, biasHorEdges)
            "Vertical_edges" -> convolute(input, verEdges, factorVerEdges, biasVerEdges)
            "Sharpen" -> convolute(input, sharpen, factorSharpen, biasSharpen)
            else -> convolute(input, motion, factorMotion, biasMotion)
        }

        val typeInd = path.lastIndexOf('.')
        val pathNoType = path.substring(0, typeInd)
        val pathType = path.substring(typeInd)
        val outPath = pathNoType + "_with$filter" + pathType
        //println("OUTPATH is $outPath")
        downloadPic(outPath, result)
        return outPath
    }
}
