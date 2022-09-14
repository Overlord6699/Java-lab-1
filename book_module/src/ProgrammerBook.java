public class ProgrammerBook extends Book {
    private String language;
    private int level;
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ProgrammerBook book = (ProgrammerBook) obj;

        return (
                (language != null && book.equals(book.language))
                        && (level == book.level)
                        && super.equals(obj)
        );
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();

        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + level;

        return result;
    }

    @Override
    public String toString()
    {
        String result = super.toString();

        result += "language: " + language + "\n";
        result += "level: " + level + "\n";

        return result;
    }
}
