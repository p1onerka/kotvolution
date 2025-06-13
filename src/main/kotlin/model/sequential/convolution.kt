package model.sequential

import org.bytedeco.opencv.opencv_core.Mat
import kotlin.math.max
import kotlin.math.min

fun convolve (pic: Mat, filter: Array<DoubleArray>, factor: Double, bias: Double): Mat {
    val w = pic.cols()
    val h = pic.rows()
    val res = pic.clone()
    val filterSize = filter.size

    for (y in 0 until h) {
        for (x in 0 until w) {
            var blue = 0.0
            var green = 0.0
            var red = 0.0

            for (filterY in 0 until filterSize) {
                for (filterX in 0 until filterSize) {
                    val imageX = (x - filterSize / 2 + filterX + w) % w
                    val imageY = (y - filterSize / 2 + filterY + h) % h

                    val buf = ByteArray(3)
                    blue += (pic.ptr(imageY, imageX).get(0).toInt() and 0xFF).toDouble() * filter[filterY][filterX]
                    green += (pic.ptr(imageY, imageX).get(1).toInt() and 0xFF).toDouble() * filter[filterY][filterX]
                    red += (pic.ptr(imageY, imageX).get(2).toInt() and 0xFF).toDouble() * filter[filterY][filterX]
                }
            }

            val b = min(255.0, max(0.0, (factor * blue + bias))).toInt().toByte()
            val g = min(255.0, max(0.0, (factor * green + bias))).toInt().toByte()
            val r = min(255.0, max(0.0, (factor * red + bias))).toInt().toByte()

            res.ptr(y, x).put(0L, b)
            res.ptr(y, x).put(1L, g)
            res.ptr(y, x).put(2L, r)
        }
    }
    return res
}