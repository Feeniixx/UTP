
package zad2;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                if (i > 4) {
                    if (j > 4) {
                        System.out.print("-");
                    }
                    else  {
                        System.out.print("*");
                    }
                } else if (j > 4) {
                    System.out.print("*");
                }
                else  {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }


            }

// by Michal Skrzekut LATE 2019