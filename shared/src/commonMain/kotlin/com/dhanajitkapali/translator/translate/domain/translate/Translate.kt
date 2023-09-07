package com.dhanajitkapali.translator.translate.domain.translate

import com.dhanajitkapali.translator.core.domain.Util.Resource
import com.dhanajitkapali.translator.core.domain.language.Language
import com.dhanajitkapali.translator.translate.domain.history.HistoryDataSource
import com.dhanajitkapali.translator.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage, fromText, toLanguage
            )

            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText,
                )
            )

            Resource.Success(translatedText)
        } catch(e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}