
public class Block {
    private PaintColour paintcolour;
    private Shape shape;

    PaintColour getPaintColour() {
        return paintcolour;
    }

    Shape getShape() {
        return shape;
    }

    public Block(PaintColour paintcolour, Shape shape) {
        this.paintcolour = paintcolour;
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return paintcolour == block.paintcolour &&
                shape == block.shape;
    }

}
