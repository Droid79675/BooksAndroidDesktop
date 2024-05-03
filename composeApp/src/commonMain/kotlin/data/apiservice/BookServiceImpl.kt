package data.apiservice

import data.models.DataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookServiceImpl: BookService {

    private fun createOkHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())
        return okHttpBuilder.build()
    }

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private fun provideBaseUrl(): String = "https://www.googleapis.com/"

    private fun createBookService(
        retrofit: Retrofit
    ): BookService = retrofit.create(BookService::class.java)

    override suspend fun getBooksByTitle(title: String): DataModel {
        return createBookService(createRetrofit(createOkHttpClient(), provideBaseUrl())).getBooksByTitle(
            "intitle:$title"
        )
    }

    override suspend fun getBooksByAuthor(author: String): DataModel {
        return createBookService(createRetrofit(createOkHttpClient(), provideBaseUrl())).getBooksByAuthor("inauthor:$author")
    }
}
