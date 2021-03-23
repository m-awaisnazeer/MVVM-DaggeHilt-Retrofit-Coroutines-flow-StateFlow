package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.adapter.PostRecyclerViewAdapter
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.databinding.ActivityMainBinding
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.util.APIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postRecyclerViewAdapter: PostRecyclerViewAdapter

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        mainViewModel.getPosts()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect {
                when (it) {
                    is APIState.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.recyclerview.isVisible = false
                    }
                    is APIState.Success -> {
                        binding.progressBar.isVisible = false
                        binding.recyclerview.isVisible = true
                        postRecyclerViewAdapter.setData(it.data)
                    }
                    is APIState.Error -> {
                        binding.progressBar.isVisible = false
                        binding.recyclerview.isVisible = true
                        Toast.makeText(this@MainActivity, "${it.msg}", Toast.LENGTH_SHORT).show()
                    }
                    else -> {

                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        postRecyclerViewAdapter = PostRecyclerViewAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postRecyclerViewAdapter
        }
    }
}