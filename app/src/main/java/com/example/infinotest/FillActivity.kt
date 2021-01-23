package com.example.infinotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infinotest.logic.FillAdapter
import com.example.infinotest.model.ItemFill
import com.example.infinotest.repos.FillRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FillActivity : AppCompatActivity(),FillAdapter.OnCardClickListner {
    private var activity:FillActivity?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_path_9205)
        activity=this
        setTitle(R.string.head_b_check)

        val recView = findViewById<RecyclerView>(R.id.recycleView)
        recView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        //load data async
        lifecycleScope.launch {
           try {
               val feed = withContext(Dispatchers.IO) {
                   FillRepo().getAll()
               }
               val adapter = FillAdapter(feed)
               adapter.onClickListener = activity
               recView.adapter = adapter
           }catch(e:Exception) {
               Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
           }
        }

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home->finish()
        }
        return true
    }

    override fun onCardClicked(rowData: ItemFill) {
        Toast.makeText(this, "Clicked ${rowData.person.name} ${rowData.person.familyName}", Toast.LENGTH_SHORT).show()
    }
}