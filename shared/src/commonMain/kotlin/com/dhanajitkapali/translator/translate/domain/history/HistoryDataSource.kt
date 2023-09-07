package com.dhanajitkapali.translator.translate.domain.history

import com.dhanajitkapali.translator.core.domain.Util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}