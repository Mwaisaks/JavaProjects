public class Book {
    String title;
    String author;
    int publicationYear;
    int pageCount;

    //constructor
    Book(String title, String author, int publicationYear, int pageCount){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    @Override
    public String toString(){
        return title + " by " + author + " (" + publicationYear + ", " + pageCount + " pages)" ;
    }

}
