class Solution {
public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList();
    if(digits.length()==0)
    return result;

    HashMap<String,String> map = new HashMap();
    map.put("2","abc"); map.put("3","def"); map.put("4","ghi"); map.put("5","jkl");
    map.put("6","mno"); map.put("7","pqrs"); map.put("8","tuv"); map.put("9","wxyz");

    Deque<String> a = new ArrayDeque();
    a.add("");

    for(int i=0; i<digits.length(); i++){
        String d = digits.substring(i,i+1);
        String fromMap = map.get(d);
        int n = a.size();
        for(int j =0; j<n ; j++){
            String pull = a.pollFirst();
            for(int k =0 ; k<fromMap.length();k++){
                String temp = pull.concat(fromMap.charAt(k)+"");
                a.add(temp);
            }
        }
    }
    while(!a.isEmpty()){
        result.add(a.poll());
    }
    return result;
	}
}