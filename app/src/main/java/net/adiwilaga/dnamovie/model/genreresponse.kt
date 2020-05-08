package net.adiwilaga.dnamovie.model
import com.google.gson.annotations.SerializedName


data class genreresponse(
    @SerializedName("genres")
    val genres: List<genre>
)