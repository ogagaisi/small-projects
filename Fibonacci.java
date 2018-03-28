public class Fibonacci{
    public static void main(String args[]) {

        int n = 10; // amount of numbers in the Fibonacci sequence
        int fn; // any number after the first two numbers in the sequence
        int numArray[] = new int[n]; // an array which stores the numbers in the sequence
        numArray[0] = 0; // the first number is always 0
        numArray[1] = 1; // the second number is always 1 
        
        for (int i = 0; i < n; i++){
            if (i < 2){ // we must have atleast two starting numbers 
                System.out.print(i + " ");
                
            }
            else{// i >= 2
                fn = numArray[i-1] + numArray[i-2]; // fn is equal to the sum of the two preceding numbers 
                System.out.print( fn + " ");
                numArray[i] = fn;
            }
        }
    }
}
