package Abstraction_and_Interface.Assignment_problems;

public class Q2 {
    static abstract class ArtPiece {
        private static int piecesCreated = 0; 

        private final String pieceId;
        private String title;

        public ArtPiece(String title) {
            piecesCreated++;         
            this.pieceId = "ART-" + piecesCreated;
            this.title = title;
        }
        public abstract String describe();
        String getPieceId() {
            return pieceId;
        }
        String getTitle() {
            return title;
        }
    }
    static class Painting extends ArtPiece {
        public Painting(String title) {
            super(title);
        }
        @Override
        public String describe() {
            return "Painting: " + getTitle() + ", framed on canvas";
        }
    }
    static class Sculpture extends ArtPiece {
        public Sculpture(String title) {
            super(title);
        }
        @Override
        public String describe() {
            return "Sculpture: " + getTitle() + ", carved from stone";
        }
    }
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());
        System.out.println(p.getPieceId());
        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
        System.out.println(s.getPieceId());
    }
}