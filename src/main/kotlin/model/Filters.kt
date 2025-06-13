package model

val BLUR =
    arrayOf(
        doubleArrayOf(0.0, 0.2, 0.0),
        doubleArrayOf(0.2, 0.2, 0.2),
        doubleArrayOf(0.0, 0.2, 0.0),
    )
const val FACTOR_BLUR = 1.0
const val BIAS_BLUR = 0.0

val ID =
    arrayOf(
        doubleArrayOf(0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 1.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0),
    )
const val FACTOR_ID = 1.0
const val BIAS_ID = 0.0

val MOTION =
    arrayOf(
        doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0),
    )
const val FACTOR_MOTION = 1.0 / 9.0
const val BIAS_MOTION = 0.0

val HOR_EDGES =
    arrayOf(
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 2.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0),
    )
const val FACTOR_HOR_EDGES = 1.0
const val BIAS_HOR_EDGES = 0.0

val VER_EDGES =
    arrayOf(
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 4.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    )
const val FACTOR_VER_EDGES = 1.0
const val BIAS_VER_EDGES = 0.0

val SHARPEN =
    arrayOf(
        doubleArrayOf(-1.0, -1.0, -1.0),
        doubleArrayOf(-1.0, 9.0, -1.0),
        doubleArrayOf(-1.0, -1.0, -1.0),
    )
const val FACTOR_SHARPEN = 1.0
const val BIAS_SHARPEN = 0.0
