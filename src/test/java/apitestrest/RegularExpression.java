package apitestrest;

import java.util.regex.*;

public class RegularExpression {

	public static void main(String[] args) {
		int count=0;
//		Pattern p = Pattern.compile("a+");
		Pattern p = Pattern.compile("[0-9]");
//		Pattern p = Pattern.compile("[A-Z]");
//		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher("25,000,000");
		System.out.println("qweqwe");
		
		while(m.find()){
			count++;
			System.out.println(m.start()+"..."+m.group());
			
		}
		
		String fullName="Artem Prokofyev";
		String name = fullName.split(" ")[0];
		String lastName = fullName.split(" ")[1];
		System.out.println(isFirstLetterCapital(name)+"  "+isFirstLetterCapital(lastName));
		
		
		System.out.println("Total number of occurences: "+count);
		
		System.out.println(isFirstLetterCapital("1rt"));

	}
	
	
	public static boolean isFirstLetterCapital(String str){
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(str.substring(0,1));
		if(m.find()){
			return true;
		}
		return false;		
	}
	

}
