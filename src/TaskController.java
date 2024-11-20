import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskController {
    LinkedList<task> tasks = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    public void addTask(String name, String desc){
        task newtask = new task(name, desc);
        tasks.add(newtask);
        exportTasks();
    }


    public void infor(){
        if(tasks.isEmpty()){
            System.out.println("No tasks");
        } else{
            for(int i = 0; i < tasks.size(); i++){
                System.out.print(i + " ");
                System.out.println(tasks.get(i).getTaskList());
            }
        }
    }

    public void getTaskByUser(){
        System.out.print("Enter task name: ");
        String tempName = scan.nextLine();
        System.out.print("Enter descritption: ");
        String tempDesc = scan.nextLine();
        addTask(tempName, tempDesc);
        exportTasks();
    }

    public void exportTasks(){
        try{
            FileOutputStream fos = new FileOutputStream("tasks.bin"); 
            ObjectOutputStream oos = new ObjectOutputStream(fos); 

            oos.writeObject(tasks); // writing tasks to file
            oos.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void loadTasks(){
        try{
            FileInputStream fis = new FileInputStream("tasks.bin");
            ObjectInputStream ois =  new ObjectInputStream(fis);

            tasks = (LinkedList<task>) ois.readObject();

            for(int i = 0; i< tasks.size(); i++){
                gui.c1.addItem(tasks.get(i).getTaskName());
            }
            ois.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void delTask(int taskId){
        tasks.remove(taskId);
        exportTasks();
    }

    public void changeTaskDescr(int taskId, String newDescr){
        tasks.get(taskId).changeDescr(newDescr);
        exportTasks();


    }

    public String getTaskDescr(int taskId){
        return tasks.get(taskId).getTaskDescr();
    }

    public void changeStat(int taskId){
        tasks.get(taskId).changeStatus();
        exportTasks();
    }

    public String getTaskStatus(int taskId){
        return tasks.get(taskId).getTaskStatus();
    }






}
