package net.adiwilaga.dnamovie.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Serializable