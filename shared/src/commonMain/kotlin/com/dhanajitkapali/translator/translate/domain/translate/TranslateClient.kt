package com.dhanajitkapali.translator.translate.domain.translate

import com.dhanajitkapali.translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}