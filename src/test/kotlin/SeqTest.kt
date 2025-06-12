//import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import model.*
import model.sequential.convolute
import org.bytedeco.opencv.global.opencv_imgcodecs
import org.bytedeco.opencv.global.opencv_imgproc.*
import org.bytedeco.opencv.opencv_core.Mat

class ConvolutionTest {

    @Test
    fun `grayscale image does not change after applying ID filter`() {
        val image = opencv_imgcodecs.imread("src/test/resources/find_pants.jpeg")
        val grayScale = Mat()
        cvtColor(image, grayScale, COLOR_BGR2GRAY)
        val res = convolute(grayScale, id, factorId, biasId)
        assertEqualsMats(grayScale, res)
    }

    @Test
    fun `colorful image does not change after applying ID filter`() {
        val image = opencv_imgcodecs.imread("src/test/resources/find_pants.jpeg")
        val res = convolute(image, id, factorId, biasId)
        assertEqualsMats(image, res)
    }
}