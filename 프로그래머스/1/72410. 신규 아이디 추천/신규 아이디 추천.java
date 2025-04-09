class Solution {
    public String solution(String new_id) {
		String s = new_id.toLowerCase();
		StringBuilder sb = new StringBuilder(s);
		
		
		
		//zeroCheck(sb);
		signCheck(sb);
		doubleDotCheck(sb);
		dotCheck(sb);
		zeroCheck(sb);
		maxLenCheck(sb);
		minLenCheck(sb);

		String answer = sb.toString();
		return answer;
	}
	
	StringBuilder signCheck(StringBuilder old_id) {
		for(int i=0;i<old_id.length();) {
			Character c = old_id.charAt(i);
			if(!(Character.isLetterOrDigit(c) || c=='-' || c=='_' || c=='.')) {
				old_id.deleteCharAt(i);
			} else {
				i++;
			}
		}
		return old_id;
	}
	
	StringBuilder doubleDotCheck(StringBuilder old_id) {
		for(int i=1;i<old_id.length();) {
			Character c = old_id.charAt(i);
			// 3. .. 두개 이상은 . 하나로
			if(c == '.' && old_id.charAt(i-1)=='.') {
				old_id.deleteCharAt(i);
			} else {
				i++;
			}
		}
		
		return old_id;
	}
	
	
	// 문자열 길이가 0인가
	StringBuilder zeroCheck(StringBuilder old_id) {
		if(old_id.length()==0) {
			old_id.append("a");
		}
		return old_id;
	}
	
	// 앞뒤 .인가
	StringBuilder dotCheck(StringBuilder old_id) {
		if(old_id.length()>0 && old_id.charAt(0) == '.') {
			old_id.deleteCharAt(0);
		}
		if(old_id.length()>0 && old_id.charAt(old_id.length()-1) == '.') {
			old_id.deleteCharAt(old_id.length()-1);
		}
		return old_id;
	}
	
	// 문자열 길이가 15 이상인가
	StringBuilder maxLenCheck(StringBuilder old_id) {
		if(old_id.length()>15) {
			old_id.delete(15, old_id.length());
		}
		dotCheck(old_id);
		return old_id;
	}
	
	// 3 미만 길이인가
	StringBuilder minLenCheck(StringBuilder old_id) {
		while(old_id.length()>0 && old_id.length()<3) {
			old_id.append(old_id.charAt(old_id.length()-1));
		}
		return old_id;
	}
}