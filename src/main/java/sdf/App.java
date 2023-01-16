package sdf;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */   
     public static void main(String[] args) {
        System.out.println("Hello World!");

        String dirPath = "\\data2";
        String fileName =""; 
        
        File newDir = new File(dirPath);
        if(newDir.exists()){
            System.out.println("Directory already exists");
        }
        else{
            newDir.mkdir();
        }

        System.out.println("Welcome to My Shopping Cart");

        List<String> cartItems = new ArrayList<String>();
        
        Console con = System.console();
        String input = "";

        while(!input.equals("quit")){
            input = con.readLine("What do you want to perform (type quit to exit prog)");

            switch(input) {
                case "help":
                    displayMsg("list - show a list of item in shopping cart");
                    displayMsg("login <name> - to access your shopping cart");
                    displayMsg("add <items> - add item to your shopping cart");
                    displayMsg("delete <item#> - delete from cart");
                    displayMsg("quit - exit this program");
                    break;
                case "list":
                    if(cartItems.size()>0){
                        for(String item:cartItems){
                            System.out.print(item);
                        }
                    }
                    else{
                        displayMsg("You cart is empty");
                    }
                    break;
                case "users":
                    break;
            }

            if(input.startsWith("add")){
                input = input.replace(",", " ");

                String strValue;
                Scanner scanner = new Scanner(input.substring(4));
                while(scanner.hasNext()){
                    strValue = scanner.next();
                    cartItems.add(strValue);
                }
            }
        }
    }

    public static void displayMsg(String msg){
        System.out.print(msg);
    }
}

