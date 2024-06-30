package com.pixelcarrot.broccoli.feature.spotify.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.pixelcarrot.broccoli.common.ui.theme.BroccoliTheme
import com.pixelcarrot.broccoli.feature.spotify.viewmodel.SpotifyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpotifyActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[SpotifyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BroccoliTheme {
                SpotifyScreen(viewModel)
            }
        }
    }

}
