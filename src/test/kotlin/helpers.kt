import model.*
import model.sequential.convolute
import org.bytedeco.opencv.global.opencv_imgcodecs
import org.bytedeco.opencv.global.opencv_imgproc
import org.bytedeco.opencv.opencv_core.Mat

val shiftLeft = arrayOf(
    doubleArrayOf(0.0, 0.0, 0.0),
    doubleArrayOf(1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0))
val shiftRight = arrayOf(
    doubleArrayOf(0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 1.0),
    doubleArrayOf(0.0, 0.0, 0.0))


fun assertEqualsMats(mat1: Mat, mat2: Mat) {
    if (mat1.empty() && mat2.empty()) return
    for (x in 0 until mat1.cols()) {
        for (y in 0 until mat1.rows()) {
            val mat1B = mat1.ptr(y, x).get(0).toInt() and 0xFF
            val mat1G = mat1.ptr(y, x).get(1).toInt() and 0xFF
            val mat1R = mat1.ptr(y, x).get(2).toInt() and 0xFF
            val mat2B = mat2.ptr(y, x).get(0).toInt() and 0xFF
            val mat2G = mat2.ptr(y, x).get(1).toInt() and 0xFF
            val mat2R = mat2.ptr(y, x).get(2).toInt() and 0xFF
            //if (mat1B != mat2B) { println("Blue on ($x, $y) is $mat1B, should be $mat2B") }
            //if(mat1G != mat2G) { println("Green on ($x, $y) is $mat1G, should be $mat2G") }
            //if(mat1R != mat2R) { println("Red on ($x, $y) is $mat1R, should be $mat2R") }
            assert(mat1B == mat2B)
            assert(mat1G == mat2G)
            assert(mat1R == mat2R)
        }
    }
}

open class ConvolutionTestTemplate {

    fun checkGrayscaleID(path: String, func: (Mat, Array<DoubleArray>, Double, Double)->Mat) {
        val image = opencv_imgcodecs.imread(path)
        val grayScale = Mat()
        opencv_imgproc.cvtColor(image, grayScale, opencv_imgproc.COLOR_BGR2GRAY)
        val res = func(grayScale, id, factorId, biasId)
        assertEqualsMats(grayScale, res)
    }

    fun checkColorfulID(path: String, func: (Mat, Array<DoubleArray>, Double, Double) -> Mat) {
        val image = opencv_imgcodecs.imread(path)
        val res = func(image, id, factorId, biasId)
        assertEqualsMats(image, res)
    }

    fun checkColorfulBlur(path: String, func: (Mat, Array<DoubleArray>, Double, Double) -> Mat) {
        val image = opencv_imgcodecs.imread(path)
        val exp = convolute(image, blur, factorBlur, biasBlur)
        val act = func(image, blur, factorBlur, biasBlur)
        assertEqualsMats(exp, act)
    }

    fun checkShiftsIdentity(path: String, func: (Mat, Array<DoubleArray>, Double, Double) -> Mat) {
        val image = opencv_imgcodecs.imread(path)
        val res = func(image, shiftLeft, 1.0, 0.0)
        val res2 = func(res, shiftRight, 1.0, 0.0)
        assertEqualsMats(image, res2)
    }
}

open class ConvolutionFrameTestTemplate {

    fun checkGrayscaleID(path: String, func: (Mat, Array<DoubleArray>, Double, Double, Int, Int)->Mat, w: Int, h: Int) {
        val image = opencv_imgcodecs.imread(path)
        val grayScale = Mat()
        opencv_imgproc.cvtColor(image, grayScale, opencv_imgproc.COLOR_BGR2GRAY)
        val res = func(grayScale, id, factorId, biasId, w, h)
        assertEqualsMats(grayScale, res)
    }

    fun checkColorfulID(path: String, func: (Mat, Array<DoubleArray>, Double, Double, Int, Int) -> Mat, w: Int, h: Int) {
        val image = opencv_imgcodecs.imread(path)
        val res = func(image, id, factorId, biasId, w, h)
        assertEqualsMats(image, res)
    }

    fun checkColorfulBlur(path: String, func: (Mat, Array<DoubleArray>, Double, Double, Int, Int) -> Mat, w: Int, h: Int) {
        val image = opencv_imgcodecs.imread(path)
        val exp = convolute(image, blur, factorBlur, biasBlur)
        val act = func(image, blur, factorBlur, biasBlur, w, h)
        assertEqualsMats(exp, act)
    }

    fun checkShiftsIdentity(path: String, func: (Mat, Array<DoubleArray>, Double, Double, Int, Int) -> Mat, w: Int, h: Int) {
        val image = opencv_imgcodecs.imread(path)
        val res = func(image, shiftLeft, 1.0, 0.0, w, h)
        val res2 = func(res, shiftRight, 1.0, 0.0, w, h)
        assertEqualsMats(image, res2)
    }
}