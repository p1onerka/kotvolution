package model.parallel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.bytedeco.opencv.opencv_core.Mat
import kotlin.math.max
import kotlin.math.min

fun convolveY(
    pic: Mat,
    filter: Array<DoubleArray>,
    factor: Double,
    bias: Double,
): Mat =
    runBlocking {
        val w = pic.cols()
        val h = pic.rows()
        val res = pic.clone()
        val filterSize = filter.size

        for (y in 0 until h) {
            launch(Dispatchers.Default) {
                for (x in 0 until w) {
                    var blue = 0.0
                    var green = 0.0
                    var red = 0.0

                    for (filterY in 0 until filterSize) {
                        for (filterX in 0 until filterSize) {
                            val imageX = (x - filterSize / 2 + filterX + w) % w
                            val imageY = (y - filterSize / 2 + filterY + h) % h

                            blue += (pic.ptr(imageY, imageX).get(0).toInt() and 0xFF) * filter[filterY][filterX]
                            green += (pic.ptr(imageY, imageX).get(1).toInt() and 0xFF) * filter[filterY][filterX]
                            red += (pic.ptr(imageY, imageX).get(2).toInt() and 0xFF) * filter[filterY][filterX]
                        }
                    }

                    val b = min(255.0, max(0.0, factor * blue + bias)).toInt().toByte()
                    val g = min(255.0, max(0.0, factor * green + bias)).toInt().toByte()
                    val r = min(255.0, max(0.0, factor * red + bias)).toInt().toByte()

                    res.ptr(y, x).put(0L, b)
                    res.ptr(y, x).put(1L, g)
                    res.ptr(y, x).put(2L, r)
                }
            }
        }
        return@runBlocking res
    }

fun convolveX(
    pic: Mat,
    filter: Array<DoubleArray>,
    factor: Double,
    bias: Double,
): Mat =
    runBlocking {
        val w = pic.cols()
        val h = pic.rows()
        val res = pic.clone()
        val filterSize = filter.size

        for (x in 0 until w) {
            launch(Dispatchers.Default) {
                for (y in 0 until h) {
                    var blue = 0.0
                    var green = 0.0
                    var red = 0.0

                    for (filterY in 0 until filterSize) {
                        for (filterX in 0 until filterSize) {
                            val imageX = (x - filterSize / 2 + filterX + w) % w
                            val imageY = (y - filterSize / 2 + filterY + h) % h

                            blue += (pic.ptr(imageY, imageX).get(0).toInt() and 0xFF) * filter[filterY][filterX]
                            green += (pic.ptr(imageY, imageX).get(1).toInt() and 0xFF) * filter[filterY][filterX]
                            red += (pic.ptr(imageY, imageX).get(2).toInt() and 0xFF) * filter[filterY][filterX]
                        }
                    }

                    val b = min(255.0, max(0.0, factor * blue + bias)).toInt().toByte()
                    val g = min(255.0, max(0.0, factor * green + bias)).toInt().toByte()
                    val r = min(255.0, max(0.0, factor * red + bias)).toInt().toByte()

                    res.ptr(y, x).put(0L, b)
                    res.ptr(y, x).put(1L, g)
                    res.ptr(y, x).put(2L, r)
                }
            }
        }

        return@runBlocking res
    }

fun convolvePixel(
    pic: Mat,
    filter: Array<DoubleArray>,
    factor: Double,
    bias: Double,
): Mat =
    runBlocking {
        val w = pic.cols()
        val h = pic.rows()
        val res = pic.clone()
        val filterSize = filter.size

        for (y in 0 until h) {
            for (x in 0 until w) {
                launch(Dispatchers.Default) {
                    var blue = 0.0
                    var green = 0.0
                    var red = 0.0

                    for (filterY in 0 until filterSize) {
                        for (filterX in 0 until filterSize) {
                            val imageX = (x - filterSize / 2 + filterX + w) % w
                            val imageY = (y - filterSize / 2 + filterY + h) % h

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
        }
        return@runBlocking res
    }

fun convolveFrame(
    pic: Mat,
    filter: Array<DoubleArray>,
    factor: Double,
    bias: Double,
    frameW: Int,
    frameH: Int,
): Mat =
    runBlocking {
        val w = pic.cols()
        val h = pic.rows()
        val res = pic.clone()
        val filterSize = filter.size

        for (y in 0 until h step frameH) {
            for (x in 0 until w step frameW) {
                val endFrameX = min(x + frameW, w)
                val endFrameY = min(y + frameH, h)
                launch(Dispatchers.Default) {
                    for (frameY in y until endFrameY) {
                        for (frameX in x until endFrameX) {
                            var blue = 0.0
                            var green = 0.0
                            var red = 0.0

                            for (filterY in 0 until filterSize) {
                                for (filterX in 0 until filterSize) {
                                    val imageX = (frameX - filterSize / 2 + filterX + w) % w
                                    val imageY = (frameY - filterSize / 2 + filterY + h) % h

                                    blue += (
                                        pic.ptr(imageY, imageX).get(0)
                                            .toInt() and 0xFF
                                    ).toDouble() * filter[filterY][filterX]
                                    green += (
                                        pic.ptr(imageY, imageX).get(1)
                                            .toInt() and 0xFF
                                    ).toDouble() * filter[filterY][filterX]
                                    red += (
                                        pic.ptr(imageY, imageX).get(2)
                                            .toInt() and 0xFF
                                    ).toDouble() * filter[filterY][filterX]
                                }
                            }

                            val b = min(255.0, max(0.0, (factor * blue + bias))).toInt().toByte()
                            val g = min(255.0, max(0.0, (factor * green + bias))).toInt().toByte()
                            val r = min(255.0, max(0.0, (factor * red + bias))).toInt().toByte()

                            res.ptr(frameY, frameX).put(0L, b)
                            res.ptr(frameY, frameX).put(1L, g)
                            res.ptr(frameY, frameX).put(2L, r)
                        }
                    }
                }
            }
        }
        return@runBlocking res
    }
