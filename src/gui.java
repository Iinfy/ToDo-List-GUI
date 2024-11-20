
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gui implements ActionListener{

    public static JFrame j1 = new JFrame("ToDo List"); // Main frame
    
    //PANELS
    public static JPanel p1 = new JPanel(); // Main panel
    public static JPanel p2 = new JPanel(); // Task info panel

    //COMBOBOXES
    public static JComboBox c1 = new JComboBox<>(); // Task chooser 

    //LABELS
    public static JLabel jL1 = new JLabel("Choose Task"); // Info label
    public static JLabel jL2 = new JLabel("Enter name"); // Task create "Enter name" label
    public static JLabel jL3 = new JLabel("Enter description"); //Task create "Enter decription" label
    public static JLabel jLTI1 = new JLabel("Name: "); //Task name display
    public static JLabel jLTI2 = new JLabel("Description: "); //Task description display
    public static JLabel jLTI3 = new JLabel("Status: "); //Task status display
    public static JLabel jLTIS1 = new JLabel("----------------------------------"); //Spliting string
    public static JLabel jLTIS2 = new JLabel("----------------------------------"); //Spliting string
    public static JLabel jLTIS3 = new JLabel("----------------------------------");
    public static JLabel jLTI = new JLabel("Task info"); //Task info label

    //BUTTONS
    public static JButton jB1 = new JButton("New task"); // New task button
    public static JButton jB2 = new JButton("Edit"); // Task edit button
    public static JButton jB3 = new JButton("Complete"); // Task completion button
    public static JButton jB4 = new JButton("Delete"); // Task delete button

    //TEXT AREAS
    public static JTextField jTA1 = new JTextField(25); // New task name getter
    public static JTextArea jTA2 = new JTextArea(4,255); // New task decription getter
    public static JTextArea jTA3 = new JTextArea(4,255); // Task decription changer

    //FONTS
    public Font defaultf = new Font("Arial",Font.BOLD,13);// Main font
    public Font defaultNewTaskLabelsFont = new Font("Arial",Font.BOLD,10); // Font for labels in new task creation zone
    public Font taskInfoFont = new Font("Arial",Font.BOLD,20);
    public Font taskInfoFontB = new Font("Arial",Font.BOLD,25);

    //Variables
    public static String jB2Status = "Edit";
    

    public void start(){
        //Frame settings
        j1.setSize(400,441);
        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.add(p1);
        j1.setResizable(false);

        //Main panel settings
        p1.setLayout(null);
        p1.add(c1);
        p1.add(jL1);
        p1.add(jB1);
        p1.add(p2);
        p1.setBackground(Color.decode("#ADADAD"));
        p1.add(jB2);
        p1.add(jB3);
        p1.add(jB4);
        p1.add(jL2);
        p1.add(jL3);
        p1.add(jTA1);
        p1.add(jTA2);

        //Task info panel
        p2.setBounds(100, 0, 400, 400);
        p2.setBackground(Color.decode("#83677B"));
        p2.setLayout(null);
        p2.add(jLTI1);
        p2.add(jLTI2);
        p2.add(jLTI3);
        p2.add(jLTIS1);
        p2.add(jLTIS2);
        p2.add(jLTI);
        p2.add(jLTIS3);
        p2.add(jTA3);
        

        //ComboBox settings
        c1.setBounds(0,20,100,20);
        c1.setBackground(Color.decode("#ADADAD"));
        c1.addActionListener(this);
        c1.setActionCommand("taskset");
        
        
        //New Task button settings
        jB1.setBounds(5,260,90,30);
        jB1.addActionListener(this);
        jB1.setActionCommand("new task");

        //New task name getter area
        jTA1.setBounds(5,310,90,20);
        
        //New task decriptiong getter area
        jTA2.setBounds(5,350,90,50);
        jTA2.setLineWrap(true);
        jTA2.setRows(3);
        jTA2.setTabSize(25);
        
        //Text Info label Left Top
        jL1.setFont(defaultf);
        jL1.setBounds(8,3,100,20);

        //Task create labels
        jL2.setBounds(5, 290, 100, 20);
        jL2.setFont(defaultNewTaskLabelsFont);
        jL3.setBounds(5,330,100,20);
        jL3.setFont(defaultNewTaskLabelsFont);

        //Task edit button
        jB2.setBounds(5,50,90,60);
        jB2.addActionListener(this);
        jB2.setActionCommand("Edit task");

        //Task completion button
        jB3.setBounds(5,120,90,60);
        jB3.addActionListener(this);
        jB3.setActionCommand("Complete");

        //Task delete button
        jB4.setBounds(5,190,90,60);
        jB4.addActionListener(this);
        jB4.setActionCommand("Delete");

        //Task info label
        jLTI.setBounds(88,0,300,50);
        jLTI.setFont(taskInfoFontB);


        //Task name display label
        jLTI1.setBounds(10,48,300,50);
        jLTI1.setFont(taskInfoFont);

        //Task spliting strings
        jLTIS1.setBounds(6,105,1000,50);
        jLTIS1.setFont(taskInfoFontB);
        jLTIS2.setBounds(6,305,1000,50);
        jLTIS2.setFont(taskInfoFontB);
        jLTIS3.setBounds(6,25,1000,50);
        jLTIS3.setFont(taskInfoFontB);

        //Task description label
        jLTI2.setBounds(10,130,260,50);
        jLTI2.setFont(taskInfoFont);

        //Task status label
        jLTI3.setBounds(10,330,300,50);
        jLTI3.setFont(taskInfoFont);

        //Task change desription text area
        jTA3.setBounds(10,175,260,150);
        jTA3.setLineWrap(true);
        jTA3.setFont(taskInfoFont);
        jTA3.setEditable(false);
        jTA3.setText("Task description will be here");
        jTA3.setBackground(Color.decode("#83677B"));
        jTA3.setWrapStyleWord(true);

        

        
        


    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("new task")){
            String tempName =(String) jTA1.getText();
            String tempDescr = (String) jTA2.getText();
            Main.taskControl.addTask(tempName,tempDescr);
            c1.addItem(tempName);

        }
        else if(command.equals("taskset")){
            String selTask = (String) c1.getSelectedItem();
            jLTI1.setText("Name: " + selTask);
            jTA3.setText(Main.taskControl.getTaskDescr(c1.getSelectedIndex()));
            jLTI3.setText(Main.taskControl.getTaskStatus(c1.getSelectedIndex()));

        }
        else if(command.equals("Edit task")){
            if(jB2Status.equals("Edit")){
                jTA3.setEditable(true);
                jB2.setText("Save");
                

                jB2Status = "Save";
            } else{
                String tempDescr = (String) jTA3.getText();
                Main.taskControl.changeTaskDescr(c1.getSelectedIndex(),tempDescr);
                jTA3.setEditable(false);
                jB2.setText("Edit");
                
                jB2Status = "Edit";
            }
            


        }
        else if(command.equals("Delete")){

            c1.removeItemAt(c1.getSelectedIndex());
            Main.taskControl.delTask(c1.getSelectedIndex());
            

        }
        else if(command.equals("Complete")){
            Main.taskControl.changeStat(c1.getSelectedIndex());
            jLTI3.setText(Main.taskControl.getTaskStatus(c1.getSelectedIndex()));
        }
        else{

        }
    }


    

}