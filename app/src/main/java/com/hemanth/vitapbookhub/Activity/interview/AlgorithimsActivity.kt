package com.hemanth.vitapbookhub.Activity.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.HomeActivity
import com.hemanth.vitapbookhub.Activity.InterviewActivity
import com.hemanth.vitapbookhub.Adapter.Interview.AlgorithimsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.LanguagesRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_algorithims.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*

class AlgorithimsActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Bubble Sorting Algorithim","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FBubble%20Sort.pdf?alt=media&token=364d91ce-c7d6-4359-95ce-1535e19b431b"),
        InterviewBook(2,"Selection Sorting Algorithim","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FSelection%20Sort.pdf?alt=media&token=fe85bd89-f3ac-40fc-9a37-f6e46ff00255"),
        InterviewBook(3,"Quick Sort Algorithim","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FQuick%20Sort.pdf?alt=media&token=4754a83d-6b04-415f-a4f2-ae3c6f12a579"),
        InterviewBook(4,"Merge Sort Algorithim","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FMerge%20Sort.pdf?alt=media&token=fb37dfae-e474-40a4-b195-6a2837fb4cf6"),
        InterviewBook(5,"Insertion Sort Algorithim/Program","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FInsertion%20Sort.pdf?alt=media&token=0effdcd9-474f-47ba-a8e8-8c4fa1accfae"),
        InterviewBook(6,"Heap Sort Algorithim","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FHeap%20Sort.pdf?alt=media&token=52f931a8-f99b-4b37-b70d-5d3caeded2ac"),
        InterviewBook(7,"Cycle Sort Algorithim","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCycle%20Sort.pdf?alt=media&token=bc0934a6-3080-45e5-8092-e4a592d4b4db"),
        InterviewBook(8,"Shell Sorting Algorithim","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FShell%20Sort.pdf?alt=media&token=8377b531-3a25-4081-8e5d-4a75c7d54a2a"),
        InterviewBook(9,"Tim-Sorting Algorithim","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FTim-sort.pdf?alt=media&token=a1b67c72-d389-4f3b-800b-2446f62bfb2e"),
        InterviewBook(10,"Linked Lists Algorithm Amd Programming","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FLinked%20Lists.pdf?alt=media&token=b0df40dd-5974-4fb6-b897-8a803789c682"),
        InterviewBook(11,"Queue Data Structures Algorithim/Programming","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2Fqueue.pdf?alt=media&token=ca3f8d6c-456d-4693-9cff-bcf6c0c162fa"),
        InterviewBook(12,"Stacks Algorithim","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2Fstacks.pdf?alt=media&token=a516a222-dbb4-4900-8b19-73c78e33c829"),
        InterviewBook(13,"Trees In Data Structure","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2Ftrees.pdf?alt=media&token=68359361-46f7-4ed0-8241-c377e9bc7d0e"),
        InterviewBook(15,"A* Searching Algorithm ","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FA%20Search%20Algorithim.pdf?alt=media&token=8216b7d1-6843-4951-b591-ba765e605ca8"),
        InterviewBook(16,"Linear And Binary Search Algorithms/Programs","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FSearching.pdf?alt=media&token=de1ba1d8-6a6f-494d-acc8-3c3d8334f7e6"),
        InterviewBook(17,"Breadth First Search","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FBreadth%20First%20Search.pdf?alt=media&token=8e4b603a-0f46-404b-a0e8-5e7c9d0afa07"),
        InterviewBook(18,"DAA-Travelling Sales Man Problem","medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FDAA%20-%20Travelling%20Salesman%20Problem.pdf?alt=media&token=61d352e7-05c5-4bfa-a3c8-48d25a7d06ab"),
        InterviewBook(19,"Depth First Traversal Search","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FDepth%20First%20Traversal.pdf?alt=media&token=4c2a1ca0-b20a-4c2f-8e83-85fb6aba22c7"),
        InterviewBook(20,"KMP Algorithim For Pattern Searching","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FKMP%20Algorithm%20for%20Pattern%20Searching.pdf?alt=media&token=ca145d2a-8c87-43d9-98a2-611b19885ec5"),
        InterviewBook(21,"LRU Catch Implementation","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FLRU%20Cache%20Implementation.pdf?alt=media&token=4aff3441-71f8-4ede-8f40-566ae5934724"),
        InterviewBook(22,"Shortest Path Algorithims","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FShortest%20Path%20Algorithms.pdf?alt=media&token=8b6af1b9-667b-41ad-a19e-4e60389270a0"),
        InterviewBook(23,"Rabin-Karp Algorithim for Pattern Seeking","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FRabin-Karp%20Algorithm%20for%20Pattern%20Searching.pdf?alt=media&token=19e1c8e1-7305-45c4-be3a-ceefb0e71ab8"),
        InterviewBook(24,"Prim's Minimum Spanning Tree(MST) Algorithm","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FPrim%E2%80%99s%20(Minimum%20Spanning%20Tree)%20MST%20Algorithm.pdf?alt=media&token=dff9b2f8-8658-46ae-8c84-e309d67003f4"),
        InterviewBook(25,"Krushkal's Minimum Spanning Tree(MST) Algorithm","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FKruskal%E2%80%99s%20(Minimum%20Spanning%20Tree)%20MST%20Algorithm.pdf?alt=media&token=4ba4d4f2-8f28-4a71-859b-19b3c302795f"),
        InterviewBook(26,"Floyd-Warshall Algorithm","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FFloyd-Warshall%20Algorithm.pdf?alt=media&token=397c0bce-a6fe-421d-8874-b4db8242fc39"),
        InterviewBook(27,"Dijkstra's Shortest Part Algorithm","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FAlgorithims%2FCommon%20Algorithims%2FDijkstra%E2%80%99s%20shortest%20path%20algorithm.pdf?alt=media&token=8a77af6c-167c-46b6-a951-03cb244d3983")
        /*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: AlgorithimsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithims)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerAlgorithims)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= AlgorithimsRecyclerAdapter(this,bookInfoList)
        recyclerJava.adapter=recycleradapter
        recyclerJava.layoutManager=layoutManager
        recyclerJava.addItemDecoration(
            DividerItemDecoration(
                recyclerJava.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    fun SetUpToolbar(){
        setSupportActionBar(algotoolbar)
        supportActionBar?.title="Algorithms"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this, InterviewActivity::class.java))
                finish()
            }
            R.id.action_sort_inc ->{
                if(order==1) {
                    Collections.sort(bookInfoList, ratingcomparator)
                    order=0
                }
                else if(order==0)
                {
                    Collections.sort(bookInfoList, ratingcomparator)
                    bookInfoList.reverse()
                    order=1
                }
                else
                {
                    Collections.sort(bookInfoList, ratingcomparator)
                    order=0
                }
            }
        }
        recycleradapter.notifyDataSetChanged()

        return super.onOptionsItemSelected(item)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
