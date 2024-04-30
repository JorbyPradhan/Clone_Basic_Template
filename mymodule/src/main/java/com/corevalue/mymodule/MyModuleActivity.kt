package com.corevalue.mymodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.corevalue.mymodule.databinding.ActivityMyModuleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyModuleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyModuleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}