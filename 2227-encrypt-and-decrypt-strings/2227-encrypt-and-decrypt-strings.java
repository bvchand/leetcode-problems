class Encrypter {
    
    private Map<Character, String> key2value = new HashMap<>();;
    private Map<String, List<String>> encryptedDict = new HashMap<>();;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {        
        for(int i=0; i<keys.length; i++) {
            this.key2value.put(keys[i], values[i]);
        }
        
        for(String word: dictionary) {
            String encryptedWord = encrypt(word);
            this.encryptedDict.computeIfAbsent(encryptedWord, val -> new ArrayList<String>()).add(word);
        }   
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        Set<Character> key_set = this.key2value.keySet();
        
        for (char c: word1.toCharArray()) {
            if(key_set.contains(c))
                sb.append(this.key2value.get(c));
            else
                return "";
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        // System.out.println(encryptedDict.toString());
        if (this.encryptedDict.containsKey(word2))
            return this.encryptedDict.getOrDefault(word2, new ArrayList<String>()).size();
        return 0;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */