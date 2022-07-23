package gridPractice;

import java.io.*;
import java.util.*;



public class Main {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
    public static void main(String args[]) throws IOException {
   
    	Scanner sc  = new Scanner(System.in);
    	
    	String str=sc.next();
    	for(int i=0; i<str.length(); i++) {
    		char word = str.charAt(i);
    		
    		System.out.println(word);
    	}
    }
}
