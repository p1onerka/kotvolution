package model

val blur = arrayOf(
    doubleArrayOf(0.0, 0.2, 0.0),
    doubleArrayOf(0.2, 0.2, 0.2),
    doubleArrayOf(0.0, 0.2, 0.0))
val factorBlur = 1.0
val biasBlur = 0.0

val motion = arrayOf(
    doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0))
val factorMotion = 1.0/9.0
val biasMotion = 0.0

val horEdges = arrayOf(
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 2.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0))
val factorHorEdges = 1.0
val biasHorEdges = 0.0

val verEdges = arrayOf(
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, 4.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0),
    doubleArrayOf(0.0, 0.0, -1.0, 0.0, 0.0))
val factorVerEdges = 1.0
val biasVerEdges = 0.0

val sharpen = arrayOf(
    doubleArrayOf(-1.0, -1.0, -1.0),
    doubleArrayOf(-1.0, 9.0, -1.0),
    doubleArrayOf(-1.0, -1.0, -1.0))
val factorSharpen = 1.0
val biasSharpen = 0.0