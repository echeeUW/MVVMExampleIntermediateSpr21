package edu.uw.echee.mvvmexampleintermediate_spr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import edu.uw.echee.mvvmexampleintermediate_spr21.adapter.EmailAdapter
import edu.uw.echee.mvvmexampleintermediate_spr21.databinding.ActivityMainBinding
import edu.uw.echee.mvvmexampleintermediate_spr21.viewmodel.EmailViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailAdapter
    private val app by lazy { application as EmailApplication }
    private val emailRepository by lazy { app.emailRepository }

    private val emailViewModel by viewModels<EmailViewModel>()

    init {
        lifecycleScope.launchWhenCreated {
            emailViewModel.numOfEmails
                .onEach {
                    binding.tvCount.text = it.toString()
                }.launchIn(lifecycleScope)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnFetchEmails.setOnClickListener { emailViewModel.fetchEmails() }
            btnDeleteEmail.setOnClickListener { emailViewModel.deleteEmail() }
            initAdapter()
        }
    }





    private fun initAdapter() = with(binding) {
        adapter = EmailAdapter(listOf())
        rvEmails.adapter = adapter
    }
}
