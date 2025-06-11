package model.sequential

import org.bytedeco.opencv.opencv_core.Mat
import kotlin.math.max
import kotlin.math.min

fun convolute (pic: Mat, filter: Array<DoubleArray>, factor: Double, bias: Double): Mat {
    val w = pic.cols()
    val h = pic.rows()
    val res = pic.clone()
    val filterSize = filter.size
    val step = pic.step().toInt()
    val channels = pic.channels()

    for (y in 0 until h) {
        for (x in 0 until w) {
            var red = 0.0
            var green = 0.0
            var blue = 0.0

            for (filterY in 0 until filterSize) {
                for (filterX in 0 until filterSize) {
                    val imageX = (x - filterSize / 2 + filterX + w) % w
                    val imageY = (y - filterSize / 2 + filterY + h) % h
                    val offset = imageY * step + imageX * channels

                    blue += (pic.ptr().get(offset.toLong()).toUByte().toInt()) * filter[filterY][filterX]
                    green += (pic.ptr().get((offset + 1).toLong()).toUByte().toInt()) * filter[filterY][filterX]
                    red += (pic.ptr().get((offset + 2).toLong()).toUByte().toInt()) * filter[filterY][filterX]
                }
            }

            val r = min(255, max(0, (factor * red + bias).toInt()))
            val g = min(255, max(0, (factor * green + bias).toInt()))
            val b = min(255, max(0, (factor * blue + bias).toInt()))

            val resOffset = y * step + x * channels
            res.ptr().put(resOffset.toLong(), b.toByte())
            res.ptr().put((resOffset + 1).toLong(), g.toByte())
            res.ptr().put((resOffset + 2).toLong(), r.toByte())
        }
    }
    return res
}