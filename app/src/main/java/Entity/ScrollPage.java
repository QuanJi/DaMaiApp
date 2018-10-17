package Entity;

import android.widget.ImageView;

public class ScrollPage {
    private int imageView1,imageView2;
    private String text1,text2;
    public ScrollPage(int imageView1,String text1){
        this.imageView1=imageView1;
        this.text1=text1;
       /* this.imageView2=imageView2;

        this.text2=text2;*/
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public int getImageView1() {
        return imageView1;
    }

    public void setImageView1(int imageView1) {
        this.imageView1 = imageView1;
    }
}
