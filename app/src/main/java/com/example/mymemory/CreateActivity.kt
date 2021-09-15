package com.example.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.mymemory.models.BoardSize
import com.example.mymemory.utils.EXTRA_BOARD_SIZE

class CreateActivity : AppCompatActivity() {
    private lateinit var boardSize: BoardSize
    private var numImagesRequired = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        // go back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // get value that being passed and cast?/ create new instance as BoardSize
        boardSize = intent.getSerializableExtra(EXTRA_BOARD_SIZE) as BoardSize
        numImagesRequired = boardSize.getNumpairs()
        supportActionBar?.title = "Choose pics ( 0 / ${numImagesRequired}"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // finish this activity, go back to home  activity
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}