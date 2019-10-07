package assignment4;
import algs4.*;
/* 
* <Tsvety Sotonov>
*<Translate Codons>
*/

import java.util.Arrays;

public class TranslateCodons 
{
	public static void main(String[] args) 
	{
	 BinarySearchST<String, String> AminoTable = new BinarySearchST<String,String>(); //Codon:Amino Acid Table
    
		AminoTable.put("TTT", "Phe");		AminoTable.put("TCT", "Ser");		AminoTable.put("TAT", "Tyr");		AminoTable.put("TGT", "Cys");
        AminoTable.put("TTC", "Phe");		AminoTable.put("TCC", "Ser");		AminoTable.put("TAC", "Tyr");		AminoTable.put("TGC", "Cys");
        									AminoTable.put("TCA", "Ser");											
        AminoTable.put("TTA", "Leu");		AminoTable.put("TCG", "Ser");		AminoTable.put("TAA", "Stp");		AminoTable.put("TGG", "Trp");
        AminoTable.put("TTG", "Leu");											AminoTable.put("TAG", "Stp");		
        AminoTable.put("CTT", "Leu");		AminoTable.put("CCT", "Pro");		AminoTable.put("TGA", "Stp");		AminoTable.put("UUC", "Phe");
        AminoTable.put("CTC", "Leu");		AminoTable.put("CCC", "Pro");
        AminoTable.put("CTA", "Leu");		AminoTable.put("CCA", "Pro");		AminoTable.put("CAT", "His");		AminoTable.put("CGT", "Arg");
        AminoTable.put("CTG", "Leu");		AminoTable.put("CCG", "Pro");		AminoTable.put("CAC", "His");		AminoTable.put("CGC", "Arg");
        																											AminoTable.put("CGA", "Arg");
        AminoTable.put("ATT", "Ile");		AminoTable.put("ACT", "Thr");		AminoTable.put("CAA", "Gln");		AminoTable.put("CGG", "Arg");
        AminoTable.put("ATC", "Ile");		AminoTable.put("ACC", "Thr");		AminoTable.put("CAG", "Gln");
        AminoTable.put("ATA", "Ile");		AminoTable.put("ACA", "Thr");											AminoTable.put("AGT", "Ser");
        AminoTable.put("ATG", "Met");		AminoTable.put("ACG", "Thr");		AminoTable.put("AAT", "Asn");		AminoTable.put("AGC", "Ser");
        																		AminoTable.put("AAC", "Asn");			
        AminoTable.put("GTT", "Val");		AminoTable.put("GCT", "Ala");											AminoTable.put("AGA", "Arg");
        AminoTable.put("GTC", "Val");		AminoTable.put("GCC", "Ala");		AminoTable.put("AAA", "Lys");		AminoTable.put("AGG", "Arg");
        AminoTable.put("GTA", "Val");		AminoTable.put("GCA", "Ala");		AminoTable.put("AAG", "Lys");
        AminoTable.put("GTG", "Val");		AminoTable.put("GCG", "Ala");											AminoTable.put("GGT", "Gly");
        																		AminoTable.put("GAT", "Asp");		AminoTable.put("GGC", "Gly");
        																		AminoTable.put("GAC", "Asp");		AminoTable.put("GGA", "Gly");
        																											AminoTable.put("GGG", "Gly");
        																		AminoTable.put("GAA", "Glu");
        																		AminoTable.put("GAG", "Glu");
        																			
    		
		StdIn.fromFile("data/smallsequences.txt"); 
		String lines[] = StdIn.readAllLines();
		
		for (String line : lines) 
		{
			String species = line.split("\t")[0]; //species name 
			
			String code = line.split("\t")[1];	//String of codons
			String[] split_code = code.split("(?<=\\G.{3})");  //Breaks up string of codons every 3 spaces
			String list = Arrays.toString(split_code); //Converts array of codons into a string for formatting
			String final_code = list.replace("[", "").replace("]", "").replace(",", "");  //Final formatted codons
			
			System.out.println(species);	//prints species 
			System.out.println(final_code); //prints codons 
			
			String separator = ""; //No hyphen before the first AA
			for (String AA : split_code) 
	       {	
	        if (Arrays.asList(split_code).contains(AA)) 
	        	{  
	        		String result = AminoTable.get(AA);	
	        		System.out.print(separator+result);
	        		separator = "-"; //Inserts a hyphen between each AA
	        	}
	    
	       }
			System.out.println("\n"); //adds a space after all loops have executed once 
		}
	}
}
