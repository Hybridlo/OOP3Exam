public class Region {
    private int id;
    private String name;
    private double square;
    private int inhabitantId;

    public Region(int id, String name, double square, int inhabitantId) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.inhabitantId = inhabitantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getInhabitantId() {
        return inhabitantId;
    }

    public void setInhabitantId(int inhabitantId) {
        this.inhabitantId = inhabitantId;
    }
}