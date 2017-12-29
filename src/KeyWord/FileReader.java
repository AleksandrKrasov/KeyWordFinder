/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyWord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Саня
 */
public class FileReader {

    public FileReader() {}
    
    public ArrayList<String> readText(String root) throws FileNotFoundException{
        ArrayList<String> text = text = new ArrayList<>();
        Scanner scn = new Scanner(new File(root));
        while(scn.hasNext())
            text.add(scn.next());
        return text;
    }
    
    public ArrayList<String> readNoiseWords(String root) throws FileNotFoundException{
        ArrayList<String> noiseWords = noiseWords = new ArrayList<>();
        Scanner scn = new Scanner(new File(root));
        while(scn.hasNext())
            noiseWords.add(scn.next());
        return noiseWords;
    }
}
