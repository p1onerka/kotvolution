// import kotlinx.coroutines.runTest
import model.parallel.convolveFrame
import model.parallel.convolvePixel
import model.parallel.convolveX
import model.parallel.convolveY
import kotlin.test.Test

class ParallelTestPixel : ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convolvePixel)
    }

    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convolvePixel)
    }

    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convolvePixel)
    }

    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convolvePixel)
    }

    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convolvePixel)
    }
}

class ParallelTestY : ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convolveY)
    }

    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convolveY)
    }

    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convolveY)
    }

    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convolveY)
    }

    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convolveY)
    }
}

class ParallelTestX : ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convolveX)
    }

    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convolveX)
    }

    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convolveX)
    }

    @Test
    fun `grayscale image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convolveX)
    }

    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convolveX)
    }

    @Test
    fun `grayscale image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convolveX)
    }

    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convolveX)
    }
}

class ParallelTestFrame : ConvolutionFrameTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convolveFrame, 30, 30)
    }

    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convolveFrame, 30, 30)
    }

    @Test
    fun `colorful image 200x200 is correct after blur`() {
        checkColorfulBlur("src/test/resources/200x200.jpeg", ::convolveFrame, 30, 30)
    }

    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convolveFrame, 30, 30)
    }

    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convolveFrame, 50, 50)
    }

    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convolveFrame, 50, 50)
    }

    @Test
    fun `grayscale image 400x400 is correct after blur`() {
        checkColorfulBlur("src/test/resources/400x400.jpeg", ::convolveFrame, 50, 50)
    }

    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convolveFrame, 50, 50)
    }

    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convolveFrame, 60, 40)
    }

    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convolveFrame, 60, 40)
    }

    @Test
    fun `grayscale image 640x426 is correct after blur`() {
        checkColorfulBlur("src/test/resources/640x426.jpeg", ::convolveFrame, 60, 40)
    }

    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convolveFrame, 60, 40)
    }
}
