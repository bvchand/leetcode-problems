class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int width = 0;
        List<String> currLine = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<words.length;) {
            String word = words[i];
            if (width + word.length() <= maxWidth) {
                width += word.length() + 1;
                currLine.add(word);
                i++;
            } else {
                int totalSpaces = maxWidth - width + currLine.size();
                int added = 0, j = 0;
                while(added < totalSpaces) {
                    if(j >= currLine.size()-1)
                        j = 0;
                    currLine.set(j , currLine.get(j) + " ");
                    added++;
                    j++;
                }

                for(String str: currLine)
                    sb.append(str);
                res.add(sb.toString());

                width = 0;
                currLine = new ArrayList<>();
                sb = new StringBuilder();
            }
            
        }
        
        if(currLine.size() > 0) {
            for(int i=0; i<currLine.size()-1; i++)
                currLine.set(i , currLine.get(i) + " ");

            String lastWord = currLine.get(currLine.size()-1) + " ".repeat(maxWidth - width + 1);
            currLine.set(currLine.size()-1 , lastWord);
            for(String str: currLine)
                sb.append(str);
            res.add(sb.toString());
        }
        return res; 
    }
}


/*
["This", "is", "an", "example", "of", "text", "justification."]

res = [(["This", "is", "an"], 8), (["example", "of", "text"], 0), (["justification."], 2)]
for()
    string[] line
    int counter = 2
    line = ["justification."]
    

    
*/