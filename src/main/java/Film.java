public class Film {
    private String title;
    private int yearOfProduction;
    private String director;
    private FilmType filmType;

    Film(FilmBuilder filmbuilder) {
        this.title = filmbuilder.title;
        this.yearOfProduction = filmbuilder.yearOfProduction;
        this.director = filmbuilder.director;
        this.filmType = filmbuilder.filmType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", director='" + director + '\'' +
                ", gatunek=" + filmType +
                '}';
    }

    public static class FilmBuilder {
        private String title;
        private int yearOfProduction;
        private String director;
        private FilmType filmType;

        public FilmBuilder title(String title) {
            this.title = title;
            return this;
        }

        public FilmBuilder yearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public FilmBuilder director(String director) {
            this.director = director;
            return this;
        }

        public FilmBuilder gatunek(FilmType filmType) {
            this.filmType = filmType;
            return this;
        }

        public Film build() {
            return new Film(this);
        }

    }


}
