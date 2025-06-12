import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.runTest
import kotlin.test.Test
import model.*
import model.parallel.convoluteAsyncPixel
import model.parallel.convoluteAsyncX
import model.parallel.convoluteAsyncY
import model.sequential.convolute
import org.bytedeco.opencv.global.opencv_imgcodecs
import org.bytedeco.opencv.global.opencv_imgproc.*
import org.bytedeco.opencv.opencv_core.Mat

class ParallelTestPixel: ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convoluteAsyncPixel)
    }
    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convoluteAsyncPixel)
    }
}

class ParallelTestY: ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convoluteAsyncY)
    }
    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convoluteAsyncY)
    }
}

class ParallelTestX: ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `grayscale image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `grayscale image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convoluteAsyncX)
    }
    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convoluteAsyncX)
    }
}