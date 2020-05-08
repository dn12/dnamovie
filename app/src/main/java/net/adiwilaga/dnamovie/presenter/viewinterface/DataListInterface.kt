package id.co.xl.sisternet.presenter.viewinterface

interface DataListInterface<T> {

    fun onGetDataSuccess(res:List<T>)
    fun onGetDataFailed(error:String)

}