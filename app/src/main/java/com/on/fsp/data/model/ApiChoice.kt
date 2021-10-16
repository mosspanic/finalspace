package com.on.fsp.data.model

class ApiChoice{

    companion object {
        var paths: String="Users"
            get() {
                return paths
            }
    }

    //val paths//: String by lazy { path }
    fun setPath(path:kotlin.String){
        paths=path
    }

    fun getPath(): String {
        return paths
    }
}
