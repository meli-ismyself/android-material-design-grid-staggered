package meliismyself.com.pluralsight_androidmaterialdesign.model;

import java.util.ArrayList;

import meliismyself.com.pluralsight_androidmaterialdesign.R;

/**
 * Created by Meli Oktavia on 2/28/2016.
 */
public class Landscape2 {
    private int imageID;
    private String title;
    private String description;
    private boolean prime;

    public void setImageID(int imageID){
        this.imageID = imageID;
    }

    public  void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isPrime(){
        return prime;
    }

    public void setPrime(boolean prime){
        this.prime = prime;
    }

    public int getImageID(){
        return imageID;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public static ArrayList<Landscape2> getData(){
        ArrayList<Landscape2> dataList = new ArrayList<>();
        int[] images = getImages();

        for(int i=0; i<images.length; i++){
            Landscape2 landscape = new Landscape2();
            landscape.setImageID(images[i]);
            landscape.setTitle("Landscape " + i);
            landscape.setPrime(checkPrime(i));
            dataList.add(landscape);
        }

        return dataList;
    }

    private static boolean checkPrime(int position){
        if (position == 0 || position == 1)
            return false;

        for (int i=2; i<=position / 2 ; ++i){
            if (position % 1 == 0) {
                return false;
            }
        }
        return true;
    }

    public static int [] getImages(){
        int images[] = {
                R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,  R.drawable.img05,
                R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09, R.drawable.img10,
                R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14,  R.drawable.img15,
                R.drawable.img16, R.drawable.img17, R.drawable.img18, R.drawable.img19, R.drawable.img20

        };
        return images;
    }


}
