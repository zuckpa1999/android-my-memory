package com.example.mymemory

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.lang.Integer.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val  MARGIN_SIZE = 10
        public const val TAG ="MemoryBoardAdapter"
    }
    //figuring out how to create 1 view of our recycler view
    @RequiresApi(Build.VERSION_CODES.N)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val cardWidth = parent.width / 2 - (2 * MARGIN_SIZE * 2)
        val cardHeight = parent.height /4- (2 * MARGIN_SIZE * 2)
        val cardSideLength = min(cardWidth,cardHeight)

        //  , 2nd: parent: root viewgroup , 3rd: atached to root?
    val view  = LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)

        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE)
        // a view wrap inside of a view holder
        return ViewHolder(view)

    }

    // how many elements in recycler view
    override fun getItemCount() = numPieces


    //taking data and bind it to view holder that we pass
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int){
            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position")
            }

        }

    }

}

private fun RecyclerView.ViewHolder.bind(position: Int) {
     val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
    imageButton.setOnClickListener {
        Log.i(MemoryBoardAdapter.TAG, "Clicked on position $position")
    }

}



