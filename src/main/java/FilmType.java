public enum FilmType {
    thriller("1"),
    horror("2"),
    comedy("3"),
    scfi("4");

    private String typeFilm;

    FilmType(String typeFilm) {
        this.typeFilm = typeFilm;
    }

    public String getTypeFilm() {
        return typeFilm;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
