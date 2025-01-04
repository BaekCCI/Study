package org.example

fun main() {
    val input = readln()
    val result = ('a'..'z').associateWith { -1 }.toMutableMap()
    result.forEach {
        result[it.key] = input.indexOf(it.key)
    }
    println(result.map { it.value }.joinToString(separator = " "))
}