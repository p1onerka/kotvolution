package model

import org.bytedeco.opencv.global.opencv_imgcodecs
import org.bytedeco.opencv.global.opencv_imgproc
import org.bytedeco.opencv.opencv_core.Mat

fun uploadPic(path: String): Mat {
    val image = opencv_imgcodecs.imread(path)
    //val grayScale = Mat()
    //opencv_imgproc.cvtColor(image, grayScale, opencv_imgproc.COLOR_BGR2GRAY)
    //return grayScale
    return image
}

fun downloadPic(path: String, input: Mat) {
    opencv_imgcodecs.imwrite(path, input)
}