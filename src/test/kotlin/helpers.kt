import org.bytedeco.opencv.opencv_core.Mat

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