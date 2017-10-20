//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author u4239
// */
//public class Main {
//    
//    public static void main(String[] args) throws IOException{
//        
//        exec();
//        
//        
//    }
//    
//    public static void exec(){  
//        Process exec;  
//        try {  
//            exec = Runtime.getRuntime().exec("cmd");  
//            if ( exec.waitFor() == 0)  
//                System.out.println("Executado.");  
//            else  
//                System.out.println("ERRO");  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } catch (InterruptedException e) {  
//            e.printStackTrace();  
//        }  
//}
//}
