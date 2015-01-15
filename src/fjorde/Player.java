package fjorde;

public class Player
{
    private int id;
    private String name;
    private String color;
    private int score;
    private Bag bag;

    public Player(int id, String name, String color, Bag bag)
    {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bag = bag;
        this.bag.setPlayer(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
        this.bag.setPlayer(this);
    }

    /**
     * The closer to zero it is, the better.
     * @return an positive or zero integer
     */
    public int getScore()
    {
        return bag.getRemainingPawns();
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
