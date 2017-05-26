package cn.edu.cqjtu.weatherforecast;

/**
 * Created by mySys on 2017/5/26.
 */

public class Tool {

    private String name;
    private int ImageId;
    private int id;



    public Tool(String name, int ImageId,int id){
        this.name = name;
        this.ImageId = ImageId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return ImageId;
    }

    public int getId() {
        return id;
    }
}
