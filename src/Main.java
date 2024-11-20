

public class Main{
    public static TaskController taskControl = new TaskController();
    public static void main(String[] args){
        gui gui = new gui();
        taskControl.loadTasks();
        gui.start();
        
    }
}
