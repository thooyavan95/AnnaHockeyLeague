package com.ahl.annahockeyleague

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ahl.annahockeyleague.ahlUtils.LogoUtility
import com.ahl.annahockeyleague.ui.AhlViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private val ahlViewModel by viewModels<AhlViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ahlViewModel.getAhlData()
        ahl_bottom_nav.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }

}