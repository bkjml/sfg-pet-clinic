package matt.springframework.sfgpetclinic;

import java.util.Scanner;

public class substring {



    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Q to quit: ");
        String quit = scanner.nextLine();

        while(quit != "q"){
            System.out.print("Enter The first string: ");
            String words = scanner.nextLine();
//        String words = "abebe kebede";
            System.out.print("Enter The substring: ");
            String toFind = scanner.nextLine();
//        String toFind = "be";

            int count = 0;
            int leng = toFind.length();
            for(int i = 0; i<words.length(); i++){
                if(words.charAt(i) == toFind.charAt(0)){
                    for (int j = 1; j<leng; j++){
                        if(words.charAt(i+j) != toFind.charAt(j)){
                            break;
                        }
                    }
                }

            }
            System.out.println(count);
            System.out.print("Enter Q to quit: ");
            quit = scanner.nextLine();
        }
//        Scanner scanner = new Scanner(System.in);

    }

}
