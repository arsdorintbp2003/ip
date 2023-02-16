package Arsdorint.task;

public class Deadline extends Task {
    public static final String typeDeadline = "D";
    public String date;
    public Deadline(String description, String date) {
        super(description);
        this.date = date;
        this.taskType = "[D]";
        this.taskName = typeDeadline;
    }
    public void printTask() {
        System.out.println(this.taskType + this.getStatus()
        + " " + this.description + "(" + this.date + ")");
    }
    @Override
    public String toSave() {
        return (this.taskName + VERTICAL_BAR + binaryRes() + VERTICAL_BAR +
                this.description + VERTICAL_BAR + this.date + "\n");
    }

}
