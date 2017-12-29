/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyWord;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Саня
 */
public class KeyWordFinder {
    
    ArrayList<String> text;
    ArrayList<String> noiseWords;
    FileReader reader;
    int startLength;
    
    public KeyWordFinder(String tRoot, String nwRoot, int StartLengh) throws FileNotFoundException {
        reader = new FileReader();
        text = reader.readText(tRoot);
        noiseWords = reader.readNoiseWords(nwRoot);
        this.startLength = StartLengh;
        String[] endings = {".", ",", "!", "?", ":", ";", "),", ")."};
        for(int j=0; j<text.size(); j++){
            text.set(j, text.get(j).toLowerCase());
            for(int i=0; i<endings.length; i++){
                if(text.get(j).startsWith("(") || text.get(j).startsWith("[")){
                    text.set(j, text.get(j).substring(1, text.get(j).length()));
                }
                if(text.get(j).endsWith(endings[i])){
                    text.set(j, text.get(j).substring(0, text.get(j).length() -1 ));
                    break;
                }
            }
        }
    }
    
    public Map<String, Integer> countWords(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: text){
            if(map.containsKey(word)) map.put(word, map.get(word) + 1);
        else map.put(word, 1);
        }
        return map;
    }
    
    public void deleteNoiseWord(){
        for(int i=0; i<noiseWords.size(); i++){
            for(int j=0; j<text.size(); j++){
                if(noiseWords.get(i).equals(text.get(j))){
                    text.remove(j);
                    j --;
                }
            }
        }
    }
    
    public void deletebyLenght(){
        for(int j=0; j<text.size(); j++){
            if(text.get(j).length() < startLength){
                text.remove(j);
                j --;
            }
        }
    }
    
    public void deleteNumbers(){
        Pattern pattern1 = Pattern.compile("[0-9]");
        Matcher mather1;
        for(int j=0; j<text.size(); j++){
            mather1 = pattern1.matcher(text.get(j));
                if(mather1.find()){
                    text.remove(j);
                    j --;
            }
        }
    }

    public ArrayList<String> getText() {
        return text;
    }

    public ArrayList<String> getNoiseWords() {
        return noiseWords;
    }

    public void setStartLength(int startLength) {
        this.startLength = startLength;
    }

    public int getStartLength() {
        return startLength;
    }
}
