package org.example;

public class WordParser {
    public static String parse(String input) {
    	String[] arr1 = input.split("[\\s]");
    	StringBuilder sb = new StringBuilder();
    	for(int i=1; i<=arr1.length; i++) {
    		System.out.println(arr1[i-1]);
    		sb.append(parseWord(arr1[i-1]));
    		if(i<arr1.length)
    			sb.append(" ");
    	}
        return sb.toString();
    }
    
    private static String parseWord(String s) {
    	if (s.length() > 2) {
			if (s.contains("-")) {
				String [] tmp1 = s.split("-");
				String [] tmp2 = new String[(tmp1.length*2)-1];
				
				
				for(int i=0; i<tmp1.length; i++) {
					tmp2[i] = tmp1[i];
					System.out.print(tmp2[i]);

					if (i<tmp1.length-1) {
						tmp2[i+1] = "-";
						System.out.print(tmp2[i+1]);
					}
				}
				
//				for(int i=0; i<tmp1.length; i++) {
//					if(i==0) {
//						tmp2[i] = tmp1[i];
//						continue;
//					}
//					
//					if (i<tmp1.length-1) {
//						tmp2[i+1] = "-";
//						System.out.print(tmp2[i+1]);
//					}
//				}
				
				
				for(String b: tmp2)
					return parseWord(b);
			}
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(s.charAt(0));
			int finalPos = s.length()-1;
			if (!Character.isAlphabetic(s.charAt(finalPos))) {
				sb2.append(s.substring(1, finalPos-1).chars()
			            .distinct()
			            .count());
				sb2.append(s.charAt(finalPos-1));
			} else 
				sb2.append(s.substring(1, finalPos).chars()
			            .distinct()
			            .count());

			
		
			
			sb2.append(s.charAt(finalPos));
			
			return sb2.toString();
		}
    	else return s;
    }
}
