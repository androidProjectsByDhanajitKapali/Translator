package com.dhanajitkapali.translator.di

import com.dhanajitkapali.translator.database.TranslateDatabase
import com.dhanajitkapali.translator.translate.data.history.SqlDelightHistoryDataSource
import com.dhanajitkapali.translator.translate.data.local.DatabaseDriverFactory
import com.dhanajitkapali.translator.translate.data.remote.HttpClientFactory
import com.dhanajitkapali.translator.translate.data.translate.KtorTranslateClient
import com.dhanajitkapali.translator.translate.domain.history.HistoryDataSource
import com.dhanajitkapali.translator.translate.domain.translate.Translate
import com.dhanajitkapali.translator.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }
}