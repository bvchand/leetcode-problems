/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    Set<String> crawledUrls = new HashSet<>();
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        processUrl(startUrl, htmlParser, getHostName(startUrl));
        List<String> result = new ArrayList<>();
        result.addAll(crawledUrls);
        return result;
    }
    
    public void processUrl(String currUrl, HtmlParser htmlParser, String hostName) {
        crawledUrls.add(currUrl);
        
        List<String> childUrls = htmlParser.getUrls(currUrl);
        
        childUrls.parallelStream().filter(nextUrl -> !crawledUrls.contains(nextUrl) && Objects.equals(hostName, getHostName(nextUrl))).forEach(nextUrl -> processUrl(nextUrl, htmlParser, hostName));
    }
    
    public String getHostName(String url) {
        String domain = url.split("http://")[1];
        return domain.split("/")[0];
    }
}