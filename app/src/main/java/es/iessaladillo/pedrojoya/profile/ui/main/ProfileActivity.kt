package es.iessaladillo.pedrojoya.profile.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.R
import es.iessaladillo.pedrojoya.profile.data.local.Database
import es.iessaladillo.pedrojoya.profile.ui.avatar.AvatarActivity
import es.iessaladillo.pedrojoya.profile.ui.avatar.AvatarActivity.Companion.EXTRA_AVATAR
import es.iessaladillo.pedrojoya.profile.utils.toast
import kotlinx.android.synthetic.main.profile_activity.*
//import kotlinx.android.synthetic.main.profile_avatar.*
//import kotlinx.android.synthetic.main.profile_form.*

class ProfileActivity : AppCompatActivity() {

    private val viewModel: ProfileActivityViewModel by lazy {
        ViewModelProvider(this, ProfileActivityViewModelFactory(Database))
            .get(ProfileActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        initsViews(savedInstanceState)
    }

    private fun initsViews(savedInstanceState: Bundle?) {

        if (savedInstanceState == null)
            setDefaultElement()
        else{
            imgAvatar.setImageResource(viewModel.avatar!!.imageResId)
            lblAvatar.setText(viewModel.avatar!!.name)
        }

        imgAvatar.setOnClickListener( object  : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this, AvatarActivity::class.java).putExtra(EXTRA_AVATAR, viewModel)
                startActivity( intent)
            }
        })
    }

    private fun setDefaultElement() {
        imgAvatar.setImageResource(viewModel.database.queryDefaultAvatar().imageResId)
        lblAvatar.setText(Database.queryDefaultAvatar().name)
        viewModel.avatar = viewModel.database.queryDefaultAvatar()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.profile_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuSave) {
            save()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun save() {
        // TODO
    }

}
