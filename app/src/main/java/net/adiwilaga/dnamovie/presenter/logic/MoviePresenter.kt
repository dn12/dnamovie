package net.adiwilaga.dnamovie.presenter.logic

import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.adiwilaga.dnamovie.API.api
import net.adiwilaga.dnamovie.dnamovieApplication
import net.adiwilaga.dnamovie.model.genre
import net.adiwilaga.dnamovie.model.movie


class MoviePresenter{

    private var disposable: Disposable? = null
    val APIServices: api

    constructor(APIServices: api) {
        this.APIServices = APIServices
    }



    fun getMovie(page:Int,lst:DataListInterface<movie>) {



        disposable=APIServices.getMovie("popularity.desc", dnamovieApplication.APIKEY ,page.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({res->

                if(res.results.size>0)
                    lst.onGetDataSuccess(res.results)
                else
                    lst.onGetDataFailed("No Data Available")

                },{  error->
                    if(!error.message.isNullOrEmpty())
                        lst.onGetDataFailed(error.message!!)
                    else
                        lst.onGetDataFailed("Service Error")
                })
    }

    fun getGenre(lst:DataListInterface<genre>) {



        disposable=APIServices.getGenre( dnamovieApplication.APIKEY )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({res->

                if(res.genres.size>0)
                    lst.onGetDataSuccess(res.genres)
                else
                    lst.onGetDataFailed("No Data Available")

            },{  error->
                if(!error.message.isNullOrEmpty())
                    lst.onGetDataFailed(error.message!!)
                else
                    lst.onGetDataFailed("Service Error")
            })
    }
}