package com.dhanajitkapali.translator.Util

import com.dhanajitkapali.translator.core.domain.Util.CommonMutableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

class IOSMutableStateFlow<T>(
    initialValue: T
): CommonMutableStateFlow<T>(MutableStateFlow(initialValue))