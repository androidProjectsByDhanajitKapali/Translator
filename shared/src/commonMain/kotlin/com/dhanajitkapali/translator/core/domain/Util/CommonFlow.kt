package com.dhanajitkapali.translator.core.domain.Util

import kotlinx.coroutines.flow.Flow

expect open class CommonFlow<T>(flow: Flow<T>): Flow<T>

fun <T> Flow<T>.toCommonFlow() = CommonFlow(this)