package meliismyself.com.pluralsight_androidmaterialdesign.model;

import java.util.ArrayList;

import meliismyself.com.pluralsight_androidmaterialdesign.R;

/**
 * Created by Meli Oktavia on 2/28/2016.
 */
public class Animal {
    private int imageID;
    private String title;
    private String description;

    public void setImageID(int imageID){
        this.imageID = imageID;
    }

    public  void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
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

    public static ArrayList<Animal> getData(){
        ArrayList<Animal> dataList = new ArrayList<>();
        int[] images = getImages();

        for(int i=0; i<images.length; i++){
            Animal animal = new Animal();
            animal.setImageID(images[i]);
            animal.setTitle("animal " +i );

            dataList.add(animal);
        }

        return dataList;
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
