// import org.junit.jupiter.api.Assertions.assertEquals
import model.sequential.convolve
import kotlin.test.Test

class SequentialTest : ConvolutionTestTemplate() {
    @Test
    fun `colorful image 200x200 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/200x200.jpeg", ::convolve)
    }

    @Test
    fun `grayscale image 200x200 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/200x200.jpeg", ::convolve)
    }

    @Test
    fun `colorful image 200x200 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/200x200.jpeg", ::convolve)
    }

    @Test
    fun `colorful image 400x400 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/400x400.jpeg", ::convolve)
    }

    @Test
    fun `grayscale image 400x400 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/400x400.jpeg", ::convolve)
    }

    @Test
    fun `colorful image 400x400 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/400x400.jpeg", ::convolve)
    }

    @Test
    fun `colorful image 640x426 does not change after applying ID filter`() {
        checkColorfulID("src/test/resources/640x426.jpeg", ::convolve)
    }

    @Test
    fun `grayscale image 640x426 does not change after applying ID filter`() {
        checkGrayscaleID("src/test/resources/640x426.jpeg", ::convolve)
    }

    @Test
    fun `colorful image 640x426 does not change after applying shiftLeft and shiftRight filters`() {
        checkShiftsIdentity("src/test/resources/640x426.jpeg", ::convolve)
    }
}
