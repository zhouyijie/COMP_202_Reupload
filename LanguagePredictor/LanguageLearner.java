import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;

public class LanguageLearner{
  /**
   * count the words
   * and generate fre_vocab and eng_vocab files
   */
  public static void main(String[] args) {
    HashMap<String, Integer> french_vocab = countWords("docs/train/fre/",20);
    HashMap<String, Integer> english_vocab = countWords("docs/train/eng/",20);
    writeVocabulary(french_vocab,"fre_vocab");
    writeVocabulary(english_vocab,"eng_vocab");
  }
  /**
   * fill the files
   * the method below counts the words
   * using two catch to avoid exception
   */
  
  public static HashMap<String, Integer> countWords(String directory, int nFiles) {
    HashMap<String, Integer> words = new HashMap<String, Integer>();
    ArrayList<String> al = new ArrayList<String>();
    for(int i =1;i<=nFiles;i++){
      String nameOfFile = directory + "" + i + ".txt";
      try{
        FileReader fr = new FileReader(nameOfFile);//how to make it go from one to the number we want
        BufferedReader br = new BufferedReader(fr);
        String input = br.readLine();
        
        while(input!=null ){
          input = input.trim();
          if (!input.equals(""))
            al.add(input);
          input=br.readLine();
        }
      }
      catch(FileNotFoundException e){
        System.out.println("the file exceeded our limits");
      }
      catch(IOException e){
        System.out.println("There was a problem reading from the files");
      }
      
      for(int j = 0;j<al.size();j++){
        String temp = al.get(j);
        String[] input =temp.split(" ");
        for(int k = 0;k<input.length;k++){
          if(words.get(input[k])!=null){
            words.put(input[k],words.get(input[k])+1);    
          }
          if(words.get(input[k])==null){
            words.put(input[k],1);}
        }
      }
    }
    return words;
  }
  /**
   * write the words
   */
  
  public static void writeVocabulary(HashMap<String, Integer> vocab, String fileName) {
    List<String> keyList = new ArrayList<String>(vocab.keySet());
    Collections.sort(keyList);
    try{
    FileWriter fw = new FileWriter(fileName + ".txt");
      BufferedWriter bw = new BufferedWriter(fw);
      for (int j =0; j < keyList.size(); j++)
      {
        String temporary = keyList.get(j);
        int temp = vocab.get(temporary);
        String serialString = "" + temporary + " " + temp;
        bw.write(serialString);
        bw.newLine();
      }
      bw.close();
    }
    catch(IOException e)
    {
      System.out.println("There was an issue.");   
    }
  }
  
  
}