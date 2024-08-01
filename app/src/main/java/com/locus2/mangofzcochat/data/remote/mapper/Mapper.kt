package com.locus2.mangofzcochat.data.remote.mapper

fun interface Mapper<in From, out To> {
    fun map(from: From): To
}