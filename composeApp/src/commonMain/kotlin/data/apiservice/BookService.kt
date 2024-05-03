package data.apiservice
import data.models.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("books/v1/volumes")
    suspend fun getBooksByTitle(@Query("q")title : String): DataModel

    @GET("books/v1/volumes")
    suspend fun getBooksByAuthor(@Query("q")author: String): DataModel
}
