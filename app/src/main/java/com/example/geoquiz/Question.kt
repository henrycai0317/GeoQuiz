package com.example.geoquiz

import androidx.annotation.StringRes

//@StringRes註解用意: Android Studio內置有Lint代碼檢查器，有了此註解，它再編譯時就知道構造函數textResId
//會提供有效的資源ID，這樣一來構造函數使用無效的資源id的情況可以避免。
data class Question(@StringRes val textResId:Int,val answer : Boolean)
