package net.adiwilaga.dnamovie.view.activity

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.adiwilaga.dnamovie.API.api
import net.adiwilaga.dnamovie.R

open class BaseActivity : AppCompatActivity() {
    var TAG = "DNALOG"
    lateinit var ctx: Context;
    var dialog: Dialog? = null;
    val APIServices by lazy {
        api.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ctx=this
    }

    fun Toast(msg: String?) {
        android.widget.Toast.makeText(ctx, msg, android.widget.Toast.LENGTH_LONG).show()
    }


    fun ShowLoadingDialog() {
        try {
            dialog = ProgressDialog.show(ctx, "Loading", "Please Wait..")
        } catch (e: Exception) {
        }
    }

    fun DismisLoadingDialog() {
        try {
            if (dialog != null && dialog!!.isShowing)
                dialog!!.dismiss()
        } catch (e: Exception) {
        }
    }
}
