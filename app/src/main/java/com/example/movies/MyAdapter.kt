import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ShowItem

class MyAdapter(private val dataList: List<ShowItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.showitem_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.showImg.setImageResource(0)
        holder.showName.text = item._name
        holder.showScore.text = item._voteAverage.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val showImg: ImageView = itemView.findViewById(R.id.showImg)
        val showName: TextView = itemView.findViewById(R.id.showName)
        val showScore: TextView = itemView.findViewById(R.id.showScore)
    }
}
