class Block {
    private int colour;
    private int x;
    private int y;

    public Block() {
    }

    public Block(int colour, int x, int y) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Block{" +
                "colour=" + colour +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}