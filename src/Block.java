public class Block {
    private PaintColour paintcolour;
    private Shape shape;


    public PaintColour getPaintcolour() {
        return paintcolour;
    }

    public Shape getShape() {
        return shape;
    }


    public Block(PaintColour paintcolour, Shape shape) {
        this.paintcolour = paintcolour;
        this.shape = shape;
    }

}
