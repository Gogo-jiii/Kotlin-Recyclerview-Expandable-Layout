package com.example.recyclerviewexpandablelayout

class ModelClass(var name: String, var isShouldShowImageview: Boolean) {

    override fun toString(): String {
        return "ModelClass{" +
                "name='" + name + '\'' +
                ", shouldShowImageview=" + isShouldShowImageview +
                '}'
    }
}