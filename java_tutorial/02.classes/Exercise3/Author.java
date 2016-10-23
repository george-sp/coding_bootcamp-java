public class Author {

    // the name of the author.
    private String name;

    /*
     * Constructors
     */
    // Default Constructor
    public Author(){}

    public Author(String name) {
        this.name = name;
    }

    /*
     * Setters & Getters
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}