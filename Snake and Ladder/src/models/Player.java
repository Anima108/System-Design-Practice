package models;

public class Player {
    String name;
    int position;

    public Player(String s, int p)
    {
        this.name=s;
        this.position = p;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
