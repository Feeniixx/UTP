/**
 *
 *  @author Golunko Lizaveta S19240
 *
 */

package zad1;


public
class Main{

    public static void main(String[] args){
        byte by = 2;
        short sh = 0377;

        System.out.println("A" +(sh << by));

        char[] znaki = new char[(int)9.95];

        System.out.println("B");
        int i=0;
        do{
            znaki[i] = i > 3 ? 'X' : 'W' + 2;
        }while( i++ < znaki.length-1);

        System.out.println("C");
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                System.out.print(znaki[(j*3)+k]);
            }
            System.out.println();
        }

        System.out.println("D"+znaki[znaki.length/2]);
        i = 4;
        do{
            znaki[i] = 'Z';
        }while(znaki.length/2 > i);

        System.out.println("E");
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                System.out.print(znaki[(j*3)+k]);
            }
            System.out.println();
        }

        char zmienna = znaki[4];
        System.out.println("F"+zmienna);
        for(int j=1; j < znaki.length; j++){
            if(znaki[j] < zmienna){
                System.out.println("G"+i);
                char tmp = znaki[i];
                znaki[i] = zmienna;
                zmienna = tmp;
            }
        }

        System.out.println("H");
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){
                System.out.print(znaki[(j*3)+k]);
            }
            System.out.println();
        }

        final char a='A', d='D';
        char grade = 'B';

        switch(grade){
            case a:
            case 'B': System.out.print("wspaniale");
            case 'C': System.out.print("dobrze"); break;
            case 'd':
            case 'F':  System.out.print("nie dobrze");
        }
    }
}
