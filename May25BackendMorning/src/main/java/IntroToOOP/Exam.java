package IntroToOOP;

public class Exam {
    private int id;
    private int score;
    private ReattemptExam reattemptExam;

    public Exam() {
    }

    public Exam(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public Exam(Exam original){
        id = original.id;
        score = original.score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
