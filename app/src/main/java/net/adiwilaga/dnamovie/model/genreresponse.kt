package net.adiwilaga.dnamovie.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class genreresponse(
    @SerializedName("genres")
    val genres: List<genre>
): Serializable