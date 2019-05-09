public class Word {
    private String word;
    private Integer id;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", id=" + id +
                '}';
    }
}
