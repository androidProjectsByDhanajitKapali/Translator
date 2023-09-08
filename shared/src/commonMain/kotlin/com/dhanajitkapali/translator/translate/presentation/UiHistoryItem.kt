package com.dhanajitkapali.translator.translate.presentation

import com.dhanajitkapali.translator.presentation.UiLanguage

data class UiHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UiLanguage,
    val toLanguage: UiLanguage
)