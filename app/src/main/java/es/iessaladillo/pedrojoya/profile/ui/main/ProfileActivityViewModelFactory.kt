package es.iessaladillo.pedrojoya.profile.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.data.local.Database

@Suppress("UNCHECKED_CAST")
class ProfileActivityViewModelFactory(val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileActivityViewModel::class.java)) {
            return ProfileActivityViewModel(database) as T
        }
        throw IllegalArgumentException("Must provide ProfileActivityViewModel class")
    }

}
