import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class OTP
{
    public static void main (String[] args) throws IOException, FileNotFoundException, NoSuchAlgorithmException, NoSuchProviderException
    {
        menu();
    }
    
    static void menu() throws IOException, FileNotFoundException, NoSuchAlgorithmException, NoSuchProviderException
    {
        boolean runMenuAgain = true;
        
        while (runMenuAgain)
        {
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("What would you like to do?");
            System.out.println("[1] - Encrypt");
            System.out.println("[2] - Decrypt");
            System.out.println("[3] - Generate key");
            System.out.println("[4] - Quit");
            
            String option = keyboard.nextLine();
            
            if (option.equals("1"))
            {
                runMenuAgain = false;
                encrypt();
            }
            
            else if (option.equals("2"))
            {
                runMenuAgain = false;
                decrypt();
            }
            
            else if (option.equals("3"))
            {
                runMenuAgain = false;
                generateKey();
            }
            
            else if (option.equals("4"))
            {
                runMenuAgain = false;
                System.exit(0);
            }
            
            else
            {
                System.out.println("Invalid input - Try again");
            }
        }
    }
    
    static void encrypt() throws IOException, FileNotFoundException, NoSuchAlgorithmException, NoSuchProviderException
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Encrypt from file or input [F/i]? ");
        String encryptFrom = keyboard.nextLine().toLowerCase();
        
        if (encryptFrom.equals("f"))
        {
            System.out.print("Enter plain text file path: ");
            String inputPath = keyboard.nextLine();
            
            File inputF = new File(inputPath);
            
            if (inputF.exists() && !inputF.isDirectory())
            {
                System.out.print("Enter key file path: ");
                String keyPath = keyboard.nextLine();
                
                File keyF = new File(keyPath);
                
                if (keyF.exists() && !keyF.isDirectory())
                {
                    System.out.print("Enter output path: ");
                    String outputPath = keyboard.nextLine();
                    
                    File outputF = new File(outputPath);
                    FileWriter fw = new FileWriter(outputPath);
                    byte[] txtB = Files.readAllBytes(Paths.get(inputPath));
                    String txt = new String(txtB);
                    int i = 0;
                    
                    Scanner keyScan = new Scanner(keyF);
                    
                    while (keyScan.hasNext() && i < txt.length())
                    {
                        String keyString = keyScan.next();
                        char txtChar = txt.charAt(i);
                        
                        int keyNum = Integer.parseInt(keyString);
                        int txtNum = (int)txtChar;
                        
                        int out = (txtNum + keyNum) % 255;
                        fw.write((String.valueOf(out)) + " ");
                        
                        i++;
                    }
                    fw.close();
                }
            }
        }
        
        else if (encryptFrom.equals("i"))
        {
            System.out.print("Enter your plain text: ");
            String input = keyboard.nextLine();
            
            System.out.print("Enter key file path: ");
            String keyPath = keyboard.nextLine();
                
            File keyF = new File(keyPath);
            
            if (keyF.exists() && !keyF.isDirectory())
            {
                System.out.print("Enter output path: ");
                String outputPath = keyboard.nextLine();
                
                File outputF = new File(outputPath);
                FileWriter fw = new FileWriter(outputPath);
                int i = 0;
                
                Scanner keyScan = new Scanner(keyF);
                
                while (keyScan.hasNext() && i < input.length())
                {
                    String keyString = keyScan.next();
                    char txtChar = input.charAt(i);
                    
                    int keyNum = Integer.parseInt(keyString);
                    int txtNum = (int)txtChar;
                    
                    int out = (txtNum + keyNum) % 255;
                    fw.write((String.valueOf(out)) + " ");
                    
                    i++;
                }
                fw.close();
            }
        }
        
        else if (encryptFrom.equals(""))
        {
            System.out.print("Enter plain text file path: ");
            String inputPath = keyboard.nextLine();
            
            File inputF = new File(inputPath);
            
            if (inputF.exists() && !inputF.isDirectory())
            {
                System.out.print("Enter key file path: ");
                String keyPath = keyboard.nextLine();
                
                File keyF = new File(keyPath);
                
                if (keyF.exists() && !keyF.isDirectory())
                {
                    System.out.print("Enter output path: ");
                    String outputPath = keyboard.nextLine();
                    
                    File outputF = new File(outputPath);
                    FileWriter fw = new FileWriter(outputPath);
                    byte[] txtB = Files.readAllBytes(Paths.get(inputPath));
                    String txt = new String(txtB);
                    int i = 0;
                    
                    Scanner keyScan = new Scanner(keyF);
                    
                    while (keyScan.hasNext() && i < txt.length())
                    {
                        String keyString = keyScan.next();
                        char txtChar = txt.charAt(i);
                        
                        int keyNum = Integer.parseInt(keyString);
                        int txtNum = (int)txtChar;
                        
                        int out = (txtNum + keyNum) % 255;
                        fw.write((String.valueOf(out)) + " ");
                        
                        i++;
                    }
                    fw.close();
                }
            }
        }
        
        else
        {
            System.out.println("Invalid input - Returning to menu");
            menu();
        }
        
    }
    
    static void decrypt() throws IOException, FileNotFoundException, NoSuchAlgorithmException, NoSuchProviderException
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Decrypt from file or input [F/i]? ");
        String decryptFrom = keyboard.nextLine().toLowerCase();
        
        if (decryptFrom.equals("f"))
        {
            System.out.print("Enter encrypted text file path: ");
            String inputPath = keyboard.nextLine();
            
            File inputF = new File(inputPath);
            
            if (inputF.exists() && !inputF.isDirectory())
            {
                System.out.print("Enter key file path: ");
                String keyPath = keyboard.nextLine();
                
                File keyF = new File(keyPath);
                
                if (keyF.exists() && !keyF.isDirectory())
                {
                    System.out.print("Enter output path: ");
                    String outputPath = keyboard.nextLine();
                    
                    File outputF = new File(outputPath);
                    FileWriter fw = new FileWriter(outputPath);
                    
                    Scanner keyScan = new Scanner(keyF);
                    Scanner txtScan = new Scanner(inputF);
                    
                    while (keyScan.hasNext() && txtScan.hasNext())
                    {
                        String keyString = keyScan.next();
                        String txtString = txtScan.next();
                        
                        int keyNum = Integer.parseInt(keyString);
                        int txtNum = Integer.parseInt(txtString);
                        
                        int out = Math.floorMod((txtNum - keyNum), 255);
                        char cout = (char)out;
                        fw.write(String.valueOf(cout));
                    }
                    fw.close();
                }
            }
        }
        
        else if (decryptFrom.equals("i"))
        {
            System.out.print("Enter your encrypted text: ");
            String input = keyboard.nextLine();
            
            File inputF = new File("temp.txt");
            FileWriter ifw = new FileWriter("temp.txt");
            ifw.write(input);
            ifw.close();
            
            if (inputF.exists() && !inputF.isDirectory())
            {
                System.out.print("Enter key file path: ");
                String keyPath = keyboard.nextLine();
                
                File keyF = new File(keyPath);
                
                if (keyF.exists() && !keyF.isDirectory())
                {
                    System.out.print("Enter output path: ");
                    String outputPath = keyboard.nextLine();
                    
                    File outputF = new File(outputPath);
                    FileWriter fw = new FileWriter(outputPath);
                    
                    Scanner keyScan = new Scanner(keyF);
                    Scanner txtScan = new Scanner(inputF);
                    
                    while (keyScan.hasNext() && txtScan.hasNext())
                    {
                        String keyString = keyScan.next();
                        String txtString = txtScan.next();
                        
                        int keyNum = Integer.parseInt(keyString);
                        int txtNum = Integer.parseInt(txtString);
                        
                        int out = Math.floorMod((txtNum - keyNum), 255);
                        char cout = (char)out;
                        fw.write(String.valueOf(cout));
                    }
                    fw.close();
                    inputF.delete();
                }
            }
        }
        
        else if (decryptFrom.equals(""))
        {
            System.out.print("Enter encrypted text file path: ");
            String inputPath = keyboard.nextLine();
            
            File inputF = new File(inputPath);
            
            if (inputF.exists() && !inputF.isDirectory())
            {
                System.out.print("Enter key file path: ");
                String keyPath = keyboard.nextLine();
                
                File keyF = new File(keyPath);
                
                if (keyF.exists() && !keyF.isDirectory())
                {
                    System.out.print("Enter output path: ");
                    String outputPath = keyboard.nextLine();
                    
                    File outputF = new File(outputPath);
                    FileWriter fw = new FileWriter(outputPath);
                    
                    Scanner keyScan = new Scanner(keyF);
                    Scanner txtScan = new Scanner(inputF);
                    
                    while (keyScan.hasNext() && txtScan.hasNext())
                    {
                        String keyString = keyScan.next();
                        String txtString = txtScan.next();
                        
                        int keyNum = Integer.parseInt(keyString);
                        int txtNum = Integer.parseInt(txtString);
                        
                        int out = Math.floorMod((txtNum - keyNum), 255);
                        char cout = (char)out;
                        fw.write(String.valueOf(cout));
                    }
                    fw.close();
                }
            }
        }
        
        else
        {
            System.out.println("Invalid input - Returning to menu");
            menu();
        }
    }
    
    static void generateKey() throws IOException, FileNotFoundException, NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom rng = SecureRandom.getInstance("SHA1PRNG", "SUN");
        File f = new File("key.txt");
        FileWriter fw = new FileWriter("key.txt");
        
        for (int i = 0; i < 10000; i++)
        {
            int n = rng.nextInt(255);
            fw.write(n + " ");
        }
        fw.close();
    }
}