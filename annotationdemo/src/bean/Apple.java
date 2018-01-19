package bean;

/**
 * Created by leochu on 2018/1/16.
 */
public class Apple {
    @Fruit(fruitName = "apple pie")
    private String name;
    @Fruit(fruitLocality = "Shan Xi")
    private String locality;

    public String getName() {
        return name;
    }
    @Fruit(fruitName = "Banana")
    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }
    @Fruit(fruitLocality = "Shang Dong")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
