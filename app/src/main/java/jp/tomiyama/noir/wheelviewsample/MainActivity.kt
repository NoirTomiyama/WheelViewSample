package jp.tomiyama.noir.wheelviewsample

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.lukedeighton.wheelview.WheelView
import com.lukedeighton.wheelview.adapter.WheelAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers =
            arrayOf(
                R.drawable.zero,
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six,
                R.drawable.seven,
                R.drawable.eight,
                R.drawable.nine
            )

        wheelView.adapter = object : WheelAdapter {
            override fun getDrawable(position: Int): Drawable? {
                //return drawable here - the position can be seen in the gifs above
                return ResourcesCompat.getDrawable(
                    resources,
                    numbers[position],
                    null
                )

            }

            override fun getCount(): Int {
                //return the count
                return numbers.size
            }
        }

        wheelView.setOnWheelItemSelectedListener { parent, itemDrawable, position ->
            //the adapter position that is closest to the selection angle and it's drawable
            Log.d("parent(Selected)", parent.toString())
            Log.d("itemDrawable(Selected)", itemDrawable.toString())
            Log.d("position(Selected)", position.toString())
        }

        wheelView.onWheelItemClickListener =
            WheelView.OnWheelItemClickListener { parent, position, isSelected ->
                //the position in the adapter and whether it is closest to the selection angle
                Log.d("parent(Click)", parent.toString())
                Log.d("position(Click)", position.toString())
                Log.d("isSelected(Click)", isSelected.toString())
            }

        wheelView.onWheelAngleChangeListener = WheelView.OnWheelAngleChangeListener {
            //the new angle of the wheel
            Log.d("angle", it.toString())
        }
    }
}
